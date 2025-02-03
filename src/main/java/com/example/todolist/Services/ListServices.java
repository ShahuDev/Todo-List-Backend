package com.example.todolist.Services;

import com.example.todolist.Models.Tasks;
import com.example.todolist.Repo.TaskRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListServices {
    @Autowired
    private TaskRepo repo;

    // to get all tasks
    public ResponseEntity<List<Tasks>> getAllTasks(){
        List<Tasks> list= repo.findAll();
        if(list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(list,HttpStatus.OK);
    }

    // to get task by Id

    public ResponseEntity<Tasks> getTaskById(long id) {
        Optional<Tasks> task = repo.findById(id);
        return task.map(tasks -> new ResponseEntity<>(tasks, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    // update task
    public ResponseEntity<Tasks> updateTask(Long id, Tasks updatedTask) {
        Tasks existingTask = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task with ID " + id + " not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setCompleted(updatedTask.isCompleted());

        repo.save(existingTask);
        return new ResponseEntity<>(existingTask, HttpStatus.OK);
    }

    public ResponseEntity<Tasks> deleteTask(Long id) {
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
    }

    public ResponseEntity<Tasks> addTask(Tasks task){
        repo.save(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

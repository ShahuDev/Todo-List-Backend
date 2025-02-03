package com.example.todolist.Controller;
import com.example.todolist.Models.Tasks;
import com.example.todolist.Services.ListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ToDoListController {

    @Autowired
    private ListServices service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Tasks>> getAllTasks(){
        return service.getAllTasks();
    }

    @GetMapping("task/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable long id){
        return service.getTaskById(id);
    }
// only add task mai dikkat hai , baki sab sahi chal raha hai.
    @PutMapping("/addTask")
    public ResponseEntity<Tasks> addTask(@RequestBody Tasks task){
        return service.addTask(task);
    }

    @PostMapping("updateTask/{id}")
    public ResponseEntity<Tasks> updateTask(@RequestBody Tasks task,@PathVariable long id){
        return service.updateTask(id,task);
    }
    @DeleteMapping("task/{id}")
    public ResponseEntity<Tasks> deleteTask(@PathVariable Long id) {
        return service.deleteTask(id);

    }
}

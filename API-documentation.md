# API Documentation for ToDo List Application

## Base URL

```
http://<your_server_host>:<port_number>
```

For example: `http://localhost:8080`

---

## API Endpoints

### 1. **Hello Endpoint**

#### **GET /hello**

##### Description:

Returns a simple greeting message.

##### Request:

- No parameters required.

##### Response:

- **200 OK:**
  ```
  Hello
  ```

---

### 2. **Get All Tasks**

#### **GET /tasks**

##### Description:

Retrieves a list of all tasks.

##### Request:

- No parameters required.

##### Response:

- **200 OK:** List of tasks
  ```json
  [
    {
      "id": 1,
      "title": "Sample Task",
      "description": "This is a sample task",
      "completed": false
    },
    ...
  ]
  ```

---

### 3. **Get Task by ID**

#### **GET /task/{id}**

##### Description:

Fetches a task by its unique identifier.

##### Path Parameters:

- `id` (long) - The ID of the task.

##### Response:

- **200 OK:** Task details
  ```json
  {
    "id": 1,
    "title": "Sample Task",
    "description": "This is a sample task",
    "completed": false
  }
  ```
- **404 Not Found:** Task not found

---

### 4. **Add a New Task**

#### **PUT /addTask**

##### Description:

Adds a new task to the list.

##### Request Body:

```json
{
  "title": "New Task",
  "description": "Task details",
  "completed": false
}
```

##### Response:

- **201 Created:** Task successfully added
  ```json
  {
    "id": 2,
    "title": "New Task",
    "description": "Task details",
    "completed": false
  }
  ```
- **400 Bad Request:** Error while adding the task

---

### 5. **Update an Existing Task**

#### **POST /updateTask/{id}**

##### Description:

Updates an existing task by its ID.

##### Path Parameters:

- `id` (long) - The ID of the task to be updated.

##### Request Body:

```json
{
  "title": "Updated Task",
  "description": "Updated details",
  "completed": true
}
```

##### Response:

- **200 OK:** Task successfully updated
  ```json
  {
    "id": 2,
    "title": "Updated Task",
    "description": "Updated details",
    "completed": true
  }
  ```
- **404 Not Found:** Task not found

---

### 6. **Delete Task by ID**

#### **DELETE /task/{id}**

##### Description:

Deletes a task by its unique identifier.

##### Path Parameters:

- `id` (long) - The ID of the task to delete.

##### Response:

- **200 OK:** Task successfully deleted
- **404 Not Found:** Task not found

---

## Notes:

- Ensure that `@CrossOrigin` annotation is used if accessing the API from a frontend client hosted on a different origin.
- For Postman testing, create a collection and add these endpoints with proper configurations.
- Use `Content-Type: application/json` for POST and PUT requests.

Let me know if you need a sample Postman collection JSON export for this API.

yes


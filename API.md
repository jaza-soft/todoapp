# API doc

## Task Resource

### Find all tasks
- URL: `<baseUrl>/api/tasks`
- Method: `GET`
- Response:
    - Code: `200-Ok`

### Find One Task
- URL: `<baseUrl>/api/tasks/{taskId}`
- Method: `GET`
- Response:
    - Code: `200-Ok`

### Create One Task
- URL: `<baseUrl>/api/tasks`
- Method: `POST`
- Body: Data in JSON format `{"name": "Go to Shoping"}`
- Header:
  - 'Content-Type': 'application/json'
- Response: 
  - Code: `201-Created`, 
  - Header: 
    - 'Location': `<baseUrl>/api/tasks/{taskId}`


### Update One Task
- URL: `<baseUrl>/api/tasks/{taskId}`
- Method: `PUT`
- Body: Data in JSON format `{"name": "Go to Shoping updated"}`
- Header:
    - 'Content-Type': 'application/json'
- Response:
    - Code: `200-OK`

### Delete One Task
- URL: `<baseUrl>/api/tasks/{taskId}`
- Method: `DELETE`
- Response:
    - Code: `204-No Content`
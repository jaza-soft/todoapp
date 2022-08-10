package com.jazasoft.todoapp.restcontroller;

import com.jazasoft.todoapp.entity.Task;
import com.jazasoft.todoapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

  private final TaskService taskService;

  public TaskRestController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping
  public List<Task> findAll() {
    List<Task> taskList = taskService.findAll();
    return taskList;
  }

  @GetMapping("/{taskId}")
  public Task findOne(@PathVariable("taskId") Long id) {
    Task task = taskService.findOne(id);
    return task;
  }

  @PostMapping
  public ResponseEntity<Task> save(@RequestBody Task task) {
    Task mTask = taskService.save(task);

//    HttpHeaders headers = new HttpHeaders();
//    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mTask.getId()).toUri();
//    headers.setLocation(location);
//    return new ResponseEntity<>(mTask, headers, HttpStatus.CREATED);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(mTask.getId()).toUri();
    return ResponseEntity.created(location).body(mTask);
  }

  @PutMapping("/{taskId}")
  public ResponseEntity<?> update(@PathVariable("taskId") Long id, @RequestBody Task task) {
    task.setId(id);
    Task mTask = taskService.update(task);
    return ResponseEntity.ok(mTask);
  }

  @DeleteMapping("/{taskId}")
  public ResponseEntity<?> delete(@PathVariable("taskId") Long id) {
    taskService.delete(id);
    return ResponseEntity.noContent().build();
  }



}

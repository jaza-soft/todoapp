package com.jazasoft.todoapp.service;

import com.jazasoft.todoapp.entity.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

  private final Map<Long, Task> taskCache = new HashMap<>();

  private Long idCounter = 1L;

  public TaskService() {
    Task task = new Task(idCounter++, "Go to shopping");
    taskCache.put(task.getId(), task);
  }

  public List<Task> findAll() {
    return new ArrayList<>(taskCache.values());
  }

  public Task findOne(Long id) {
    return taskCache.get(id);
  }

  public Task save(Task task) {
    task.setId(idCounter++);
    taskCache.put(task.getId(), task);

    return task;
  }

  public Task update(Task task) {
    taskCache.put(task.getId(), task);
    return task;
  }

  public void delete(Long id) {
    taskCache.remove(id);
  }
}

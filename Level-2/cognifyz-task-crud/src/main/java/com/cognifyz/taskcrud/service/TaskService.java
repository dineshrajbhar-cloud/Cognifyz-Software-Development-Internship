package com.cognifyz.taskcrud.service;

import com.cognifyz.taskcrud.entity.Task;

import java.util.List;

public interface TaskService  {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);
}

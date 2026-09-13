package com.cognifyz.taskcrud.controller;

import com.cognifyz.taskcrud.entity.Task;
import com.cognifyz.taskcrud.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController {

     private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    ResponseEntity<Task> createTask(@RequestBody Task task){
        Task task1 = taskService.createTask(task);
        return new ResponseEntity<>(task1, HttpStatus.CREATED);
    }

}

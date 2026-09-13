package com.cognifyz.taskcrud.serviceImpl;

import com.cognifyz.taskcrud.entity.Task;
import com.cognifyz.taskcrud.repository.TaskRepository;
import com.cognifyz.taskcrud.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {

        return taskRepository.save(task);
    }
}

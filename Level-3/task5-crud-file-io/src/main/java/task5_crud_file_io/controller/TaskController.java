package task5_crud_file_io.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task5_crud_file_io.entity.Task;
import task5_crud_file_io.service.FileService;
import task5_crud_file_io.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;
    private final FileService fileService;

    public TaskController(TaskService taskService,
                          FileService fileService) {
        this.taskService = taskService;
        this.fileService = fileService;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        Task task1 = taskService.createTask(task);

        return new ResponseEntity<>(task1, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {

        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {

        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {

        return ResponseEntity.ok(
                taskService.updateTask(id, task)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.ok("Task deleted successfully");
    }

    @PostMapping("/file/save")
    public ResponseEntity<String> saveTasksToFile() {

        List<Task> tasks = taskService.getAllTasks();

        fileService.saveTasksToFile(tasks);

        return ResponseEntity.ok(
                "Tasks saved to file successfully"
        );
    }

    @GetMapping("/file/load")
    public ResponseEntity<List<Task>> loadTasksFromFile() {

        List<Task> tasks = fileService.loadTasksFromFile();

        return ResponseEntity.ok(tasks);
    }
}
package task5_crud_file_io.service;

import task5_crud_file_io.entity.Task;

import java.util.List;

public interface FileService {

    void saveTasksToFile(List<Task> tasks);

    List<Task> loadTasksFromFile();
}
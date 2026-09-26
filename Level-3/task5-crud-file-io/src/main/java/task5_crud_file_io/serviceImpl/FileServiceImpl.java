package task5_crud_file_io.serviceImpl;

import org.springframework.stereotype.Service;
import task5_crud_file_io.entity.Task;
import task5_crud_file_io.service.FileService;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private static final String FILE_PATH = "tasks.txt";

    @Override
    public void saveTasksToFile(List<Task> tasks) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Task task : tasks) {

                writer.write(
                        task.getId() + "|" +
                                task.getTitle() + "|" +
                                task.getDescription() + "|" +
                                task.getStatus() + "|" +
                                task.getCreatedAt()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Error saving tasks to file", e
            );
        }
    }

    @Override
    public List<Task> loadTasksFromFile() {

        List<Task> tasks = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length < 5) {
                    continue;
                }

                Task task = new Task();

                task.setId(Long.parseLong(data[0]));
                task.setTitle(data[1]);
                task.setDescription(data[2]);
                task.setStatus(data[3]);
                task.setCreatedAt(
                        LocalDateTime.parse(data[4])
                );

                tasks.add(task);
            }

        } catch (FileNotFoundException e) {

            // File doesn't exist yet
            return tasks;

        } catch (IOException | RuntimeException e) {

            throw new RuntimeException(
                    "Error loading tasks from file", e
            );
        }

        return tasks;
    }
}
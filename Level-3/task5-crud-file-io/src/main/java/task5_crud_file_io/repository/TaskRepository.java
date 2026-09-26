package task5_crud_file_io.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task5_crud_file_io.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}

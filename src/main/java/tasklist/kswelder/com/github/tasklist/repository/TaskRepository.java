package tasklist.kswelder.com.github.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tasklist.kswelder.com.github.tasklist.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM task WHERE id_task=? LIMIT ? OFFSET ?")
    public List<Task> findById_task(Long id, int limit, int offset);
}

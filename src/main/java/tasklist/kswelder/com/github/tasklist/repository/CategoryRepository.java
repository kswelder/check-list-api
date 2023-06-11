package tasklist.kswelder.com.github.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tasklist.kswelder.com.github.tasklist.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package tasklist.kswelder.com.github.tasklist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import tasklist.kswelder.com.github.tasklist.model.Category;
import tasklist.kswelder.com.github.tasklist.model.User;

import javax.print.attribute.standard.PageRanges;
import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryListDTO {
    private Long id;
    private String username;
    private List<CategoryDTO> categories;

    public CategoryListDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.categories = user.getCategories()
                .stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
    }
}

package tasklist.kswelder.com.github.tasklist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tasklist.kswelder.com.github.tasklist.model.Task;
import tasklist.kswelder.com.github.tasklist.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksDTO {
    private Long id;
    private String username;
    private List<Task> tasks;

    public TasksDTO(User user, List<Task> tasks) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.tasks = tasks;
    }
}

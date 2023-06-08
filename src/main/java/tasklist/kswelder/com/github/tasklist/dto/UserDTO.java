package tasklist.kswelder.com.github.tasklist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tasklist.kswelder.com.github.tasklist.model.User;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}

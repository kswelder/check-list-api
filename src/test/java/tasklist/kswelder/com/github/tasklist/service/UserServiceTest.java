package tasklist.kswelder.com.github.tasklist.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tasklist.kswelder.com.github.tasklist.dto.UserDTO;
import tasklist.kswelder.com.github.tasklist.model.User;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void save() {
        User user  = new User();
        LocalDateTime localDateTime = LocalDateTime.now();
        user.setUsername("kswelder");
        user.setPassword("12345");
        user.setCreatedAt(localDateTime);
        user.setUpdatedAt(localDateTime);
        assertTrue(Optional.of(userService.save(user)).isPresent());
    }

    @Test
    void update() {
    }

    @Test
    void listAll() {
    }

    @Test
    void findOne() {
    }

    @Test
    void deleteUser() {
    }
}
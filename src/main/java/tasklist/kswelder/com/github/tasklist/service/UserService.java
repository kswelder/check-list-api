package tasklist.kswelder.com.github.tasklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasklist.kswelder.com.github.tasklist.dto.UserDTO;
import tasklist.kswelder.com.github.tasklist.model.User;
import tasklist.kswelder.com.github.tasklist.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO save(User user) {
        if (Optional.of(user).isEmpty()) {
            throw new RuntimeException("Error");
        }
        LocalDateTime localDateTime = LocalDateTime.now();

        user.setCreatedAt(localDateTime);
        user.setUpdatedAt(localDateTime);

        userRepository.save(user);

        return new UserDTO(user);
    }
    public UserDTO update(User user) {
        if (Optional.of(user).isEmpty()) {
            throw new RuntimeException("Error");
        }
        LocalDateTime localDateTime = LocalDateTime.now();

        User register = Optional.of(userRepository.findByUsername(user.getUsername()))
                .orElseThrow(() -> new RuntimeException("Error"));

        register.setPassword(user.getPassword());
        register.setUpdatedAt(localDateTime);

        userRepository.save(register);

        return new UserDTO(register);
    }
    public List<UserDTO> listAll() {
        return userRepository.findAll().stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
    public UserDTO findOne(String username) {
        User register = Optional.of((userRepository.findByUsername(username)))
                .orElseThrow(() -> new RuntimeException("Erro\nClient not found"));
        return new UserDTO(register);
    }
    public UserDTO deleteUser(String username) {
        User register = Optional.of(userRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException("Error"));
        userRepository.delete(register);
        return new UserDTO();
    }
}

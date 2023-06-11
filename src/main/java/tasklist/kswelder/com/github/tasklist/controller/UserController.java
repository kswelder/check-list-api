package tasklist.kswelder.com.github.tasklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tasklist.kswelder.com.github.tasklist.dto.UserDTO;
import tasklist.kswelder.com.github.tasklist.model.User;
import tasklist.kswelder.com.github.tasklist.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/find/{username}")
    public ResponseEntity<UserDTO> userFindOne(@PathVariable(value = "username") String username) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.findOne(username));
    }
    @GetMapping(path = "/list")
    public ResponseEntity<List<UserDTO>> usersListAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
    }
    @PostMapping(path = "/save")
    public ResponseEntity<UserDTO> userSave(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
    @PutMapping(path = "/update/{username}")
    public ResponseEntity<UserDTO> userUpdate(@RequestBody User user, @PathVariable(value = "username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(user, username));
    }
    @DeleteMapping(path = "/delete/{username}")
    public ResponseEntity<UserDTO> userDelete(@PathVariable(value = "username") String username) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.deleteUser(username));
    }
}

package tasklist.kswelder.com.github.tasklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tasklist.kswelder.com.github.tasklist.dto.TasksDTO;
import tasklist.kswelder.com.github.tasklist.model.Task;
import tasklist.kswelder.com.github.tasklist.service.TaskService;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping(path = "/task/find/{username}/{page}")
    public ResponseEntity<TasksDTO> findUserTasks(@PathVariable(value = "username") String username, @PathVariable(value = "page") int page) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.userTasks(username, page));
    }
    @GetMapping(path = "/task/list/{page}")
    public ResponseEntity<List<Task>> listTasks(@PathVariable(value = "page") int page) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.listTasks(page));
    }
    @PostMapping(path = "/task/save/{username}")
    public ResponseEntity<Task> saveTask(@RequestBody Task task, @PathVariable(value = "username") String username) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.saveTask(task, username));
    }
    @PutMapping(path = "/task/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long id, @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id, task));
    }
    @DeleteMapping(path = "/task/delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(taskService.deleteTask(id));
    }
}

package tasklist.kswelder.com.github.tasklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tasklist.kswelder.com.github.tasklist.dto.TasksDTO;
import tasklist.kswelder.com.github.tasklist.dto.UserDTO;
import tasklist.kswelder.com.github.tasklist.model.Task;
import tasklist.kswelder.com.github.tasklist.model.User;
import tasklist.kswelder.com.github.tasklist.repository.CategoryRepository;
import tasklist.kswelder.com.github.tasklist.repository.TaskRepository;
import tasklist.kswelder.com.github.tasklist.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public TasksDTO userTasks(String username, int page) {
        User user = Optional.of(userRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException("User not found"));
        List<Task> tasks = taskRepository.findById_task(user.getId(), 5, (page - 1) * 5);
        return new TasksDTO(user, tasks);
    }
    public List<Task> listTasks(int page) {
        Pageable pageable = PageRequest.of(page-1, 5);
        return taskRepository.findAll(pageable)
                .stream()
                .collect(Collectors.toList());
    }
    public Task saveTask(Task task, String username) {
        UserDTO resister = Optional.of(userService.findOne(username))
                .orElseThrow(() -> new RuntimeException("Client not found"));
        LocalDateTime localDateTime = LocalDateTime.now();

        task.setId_category(
                Optional.of(categoryRepository.findById(task.getId_category()))
                        .orElseThrow(() -> new RuntimeException("Category not exists"))
                        .get().getId()
        );

        task.setCreatedAt(localDateTime);
        task.setUpdatedAt(localDateTime);
        task.setId_task(resister.getId());

        return taskRepository.save(task);
    }
    public Task updateTask(Long id, Task task) {
        Task registerTask = Optional.of(taskRepository.getReferenceById(id))
                .orElseThrow(() -> new RuntimeException("Task not found"));
        registerTask.setName(task.getName());
        registerTask.setUpdatedAt(LocalDateTime.now());
        registerTask.setId_task(task.getId_task());
        return taskRepository.save(registerTask);
    }
    public Task deleteTask(Long id) {
        Task registerTask = Optional.of(taskRepository.getReferenceById(id))
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(registerTask);
        return new Task();
    }

}

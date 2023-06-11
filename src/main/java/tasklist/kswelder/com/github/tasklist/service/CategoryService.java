package tasklist.kswelder.com.github.tasklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasklist.kswelder.com.github.tasklist.dto.CategoryDTO;
import tasklist.kswelder.com.github.tasklist.dto.CategoryListDTO;
import tasklist.kswelder.com.github.tasklist.model.Category;
import tasklist.kswelder.com.github.tasklist.model.User;
import tasklist.kswelder.com.github.tasklist.repository.CategoryRepository;
import tasklist.kswelder.com.github.tasklist.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO saveCategory(String username, Category category) {
        LocalDateTime localDateTime = LocalDateTime.now();
        User userRegister = Optional.of(userRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException("Client not found"));
        category.setId_category(userRegister.getId());
        category.setUpdatedAt(localDateTime);
        category.setCreatedAt(localDateTime);
        Category registerCategory = categoryRepository.save(category);
        return new CategoryDTO(registerCategory);
    }
    public CategoryListDTO getListCategory(String username) {
        User userRegister = Optional.of(userRepository.findByUsername(username))
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return new CategoryListDTO(userRegister);
    }
    public CategoryDTO updateCategory(Long id, Category category) {
        Category categoryRegister = Optional.of(categoryRepository.findById(id).get())
                .orElseThrow(() -> new RuntimeException(""));
        categoryRegister.setName(category.getName());
        categoryRegister.setUpdatedAt(LocalDateTime.now());
        categoryRepository.save(categoryRegister);
        return new CategoryDTO(categoryRegister);
    }
    public CategoryDTO deleteCategory(Long id) {
        Category categoryRegister = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""));
        categoryRepository.delete(categoryRegister);
        return new CategoryDTO();
    }
}

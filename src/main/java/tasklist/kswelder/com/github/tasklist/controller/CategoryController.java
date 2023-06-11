package tasklist.kswelder.com.github.tasklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tasklist.kswelder.com.github.tasklist.dto.CategoryDTO;
import tasklist.kswelder.com.github.tasklist.dto.CategoryListDTO;
import tasklist.kswelder.com.github.tasklist.model.Category;
import tasklist.kswelder.com.github.tasklist.service.CategoryService;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/category/list/{username}")
    public ResponseEntity<CategoryListDTO> listCategory(@PathVariable(value = "username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getListCategory(username));
    }
    @PostMapping(path = "/category/save/{username}")
    public ResponseEntity<CategoryDTO> saveCategory(@PathVariable(value = "username") String username, @RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.saveCategory(username, category));
    }
    @PutMapping(path = "/category/update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable(value = "id") Long id, @RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(id, category));
    }
    @DeleteMapping(path = "/category/delete/{id}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoryService.deleteCategory(id));
    }
}

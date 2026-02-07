package com.fun.BackendStuff.contoller;

import com.fun.BackendStuff.DTOs.CategoryDTO;
import com.fun.BackendStuff.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDTO>createCategory(@Valid @RequestBody CategoryDTO categoryDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(categoryDTO));
    }

    @GetMapping("/get")
    public ResponseEntity<CategoryDTO>getById(@RequestParam Long cId)
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryService.getCategoryById(cId));
    }

    @GetMapping("/allCategories")
    public ResponseEntity<List<CategoryDTO>> getAll()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryService.getAllCategories());
    }

    @PostMapping("/updateCategory")
    public ResponseEntity<CategoryDTO>updateCategory(Long cId,CategoryDTO categoryDTO)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoryService.updateCategory(cId,categoryDTO));
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long cId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteCategory(cId));
    }



}

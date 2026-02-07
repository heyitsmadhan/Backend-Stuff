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
@RequestMapping("/category")
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
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryById(cId));
    }

    @GetMapping("/allcategories")
    public ResponseEntity<List<CategoryDTO>> getAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @PutMapping("/updatecategory")
    public ResponseEntity<CategoryDTO>updateCategory(@RequestParam Long cId,@RequestBody CategoryDTO categoryDTO)
    {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(cId,categoryDTO));
    }

    @DeleteMapping("/deletecategory/{cId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long cId)
    {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoryService.deleteCategory(cId));
    }
    @GetMapping("/categorycheck")
    public String greet()
    {
        return "controller end point is working!";
    }

}

package com.fun.BackendStuff.service;

import com.fun.BackendStuff.DTOs.CategoryDTO;
import com.fun.BackendStuff.entity.Category;
import com.fun.BackendStuff.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    public CategoryDTO createCategory(CategoryDTO categoryDTO)
    {
        if(categoryRepository.existsByCategoryName(categoryDTO.getCategoryName()))
        {
            throw new RuntimeException(categoryDTO.getCategoryName()+" already exists!");
        }
        Category category = mapper.map(categoryDTO,Category.class);
        categoryRepository.save(category);
        return mapper.map(category,CategoryDTO.class);
    }

    public List<CategoryDTO> getAllCategories()
    {
        List<Category>allCategories = categoryRepository.findAll();
        return allCategories.stream()
                .map(category -> mapper.map(category,CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(Long cId)
    {
        Category category = categoryRepository.findById(cId).orElseThrow(()->new RuntimeException("category with "+cId+" not found!"));
        return mapper.map(category,CategoryDTO.class);
    }

    public CategoryDTO updateCategory(Long cId,CategoryDTO categoryDTO)
    {
        Category category = categoryRepository.findById(cId).orElseThrow(()-> new RuntimeException("category with "+cId+" not found!"));

        if(category.getCategoryName().equals(categoryDTO.getCategoryName()))
        {
            throw new RuntimeException("category name already exists!");
        }
        category.setCategoryName(categoryDTO.getCategoryName());
        Category savedCategory = categoryRepository.save(category);
        return mapper.map(savedCategory,CategoryDTO.class);
    }
    public String deleteCategory(Long cId)
    {
        Category category = categoryRepository.findById(cId).orElseThrow(()-> new RuntimeException("category with "+cId+" not found!"));
        categoryRepository.deleteById(category.getCategoryId());
        return "category deleted!";
    }

}

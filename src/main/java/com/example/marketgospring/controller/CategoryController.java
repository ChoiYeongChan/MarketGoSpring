package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Category;
import com.example.marketgospring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/category")
public class CategoryController {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    @GetMapping(value = "/all")
    public Iterable<Category> list() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category put(@RequestParam("category_name") String category_name) {
        return categoryRepository.save(new Category(category_name));
    }

}

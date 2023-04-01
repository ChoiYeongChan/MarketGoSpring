package com.example.marketgospring.controller;

import com.example.marketgospring.entity.Category;
import com.example.marketgospring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
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
    public Category put(@RequestParam("categoryId") Long categoryId, @RequestParam("categoryName") String categoryName) {
        return categoryRepository.save(new Category(categoryId, categoryName));
    }

    @PutMapping(value = "/{categoryId}")
    public Category update(@PathVariable("categoryId") Long categoryId, @RequestParam("categoryName") String categoryName) {
        Optional<Category> category=categoryRepository.findById(categoryId);
        category.get().setCategoryName(categoryName);
        return categoryRepository.save(category.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("categoryId") Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}

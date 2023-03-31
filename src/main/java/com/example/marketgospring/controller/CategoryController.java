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
    public Category put(@RequestParam("category_id") Long category_id, @RequestParam("category_name") String category_name) {
        return categoryRepository.save(new Category(category_id, category_name));
    }

    @PutMapping(value = "/{category_id}")
    public Category update(@PathVariable("category_id") Long category_id, @RequestParam("category_name") String category_name) {
        Optional<Category> category=categoryRepository.findById(category_id);
        category.get().setCategory_name(category_name);
        return categoryRepository.save(category.get());
    }

    @DeleteMapping
    public void delete(@RequestParam("category_id") Long category_id) {
        categoryRepository.deleteById(category_id);
    }
}

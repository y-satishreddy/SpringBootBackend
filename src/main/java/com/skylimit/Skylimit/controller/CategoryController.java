package com.skylimit.Skylimit.controller;

import com.skylimit.Skylimit.dto.category.CategoryAddCategoryRequestDTO;
import com.skylimit.Skylimit.dto.category.CategoryAddCategoryResponseDTO;
import com.skylimit.Skylimit.dto.category.CategoryGetCategoryResponseDTO;
import com.skylimit.Skylimit.service.CategoryServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl category) {
        this.categoryService = category;
    }

    @PostMapping
    public CategoryAddCategoryResponseDTO saveCategory(@Valid @RequestBody CategoryAddCategoryRequestDTO category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public CategoryGetCategoryResponseDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}

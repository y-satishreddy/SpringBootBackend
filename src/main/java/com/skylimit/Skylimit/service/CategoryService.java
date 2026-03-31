package com.skylimit.Skylimit.service;

import com.skylimit.Skylimit.dto.category.CategoryAddCategoryRequestDTO;
import com.skylimit.Skylimit.dto.category.CategoryAddCategoryResponseDTO;
import com.skylimit.Skylimit.dto.category.CategoryGetCategoryResponseDTO;

public interface CategoryService {
    public CategoryAddCategoryResponseDTO saveCategory(CategoryAddCategoryRequestDTO dto) ;
    public CategoryGetCategoryResponseDTO getCategory(Long id);
}

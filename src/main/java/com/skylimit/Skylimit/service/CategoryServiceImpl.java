package com.skylimit.Skylimit.service;

import com.skylimit.Skylimit.dto.category.CategoryAddCategoryRequestDTO;
import com.skylimit.Skylimit.dto.category.CategoryAddCategoryResponseDTO;
import com.skylimit.Skylimit.dto.category.CategoryGetCategoryResponseDTO;
import com.skylimit.Skylimit.entity.Category;
import com.skylimit.Skylimit.exception.CategoryNotFoundException;
import com.skylimit.Skylimit.mapper.CategoryMapper;
import com.skylimit.Skylimit.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryAddCategoryResponseDTO saveCategory(CategoryAddCategoryRequestDTO dto) {
        logger.info("Saving category..");
        logger.debug("Category request name={}", dto.getName());
        Category category = categoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);
        logger.info("Category saved successfully with id={}", saved.getId());
        return categoryMapper.toCreateResponse(saved);
    }

    @Override
    public CategoryGetCategoryResponseDTO getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category Not Found"));
        return categoryMapper.toDetailsResponse(category);
    }
}

package com.skylimit.Skylimit.service;

import com.skylimit.Skylimit.dto.category.CategoryAddCategoryRequestDTO;
import com.skylimit.Skylimit.dto.category.CategoryAddCategoryResponseDTO;
import com.skylimit.Skylimit.dto.category.CategoryGetCategoryResponseDTO;
import com.skylimit.Skylimit.entity.Category;
import com.skylimit.Skylimit.mapper.CategoryMapper;
import com.skylimit.Skylimit.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    @Mock
    private CategoryMapper categoryMapper;
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void saveCategoryTest() {
        CategoryAddCategoryRequestDTO dto = new CategoryAddCategoryRequestDTO("satish", "sat", 0L, 0, 1, true);

        Category category = new Category();
        Category savedCategory = new Category();

        CategoryAddCategoryResponseDTO responseDTO = new CategoryAddCategoryResponseDTO(1L, "satish", "sat", 0L, 0, 1, true, LocalDateTime.now(), LocalDateTime.now());

        when(categoryMapper.toEntity(dto)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(savedCategory);
        when(categoryMapper.toCreateResponse(savedCategory)).thenReturn(responseDTO);

        CategoryAddCategoryResponseDTO response = categoryService.saveCategory(dto);

        assertEquals("satish", response.getName());

    }

    @Test
    public void getCategoryTest() {
        Long id=1L;
        Category category = new Category();
        CategoryGetCategoryResponseDTO responseDTO=new CategoryGetCategoryResponseDTO(1L, "satish", "sat", 0L, 0, 1, true);
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        when(categoryMapper.toDetailsResponse(category)).thenReturn(responseDTO);
        CategoryGetCategoryResponseDTO response=categoryService.getCategory(id);
        assertEquals("satish",response.getName());
    }

    @Test
    public void testCategoryNotFoundException() {
        Long id=1;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());
        Exception exception=assertThrows(CategoryNotFoundException.class,() -> categoryService.getCategory(id));
        assertEquals("Category Not Found",exception.getMessage());
    }
}

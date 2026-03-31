package com.skylimit.Skylimit.mapper;

import com.skylimit.Skylimit.dto.category.CategoryAddCategoryRequestDTO;
import com.skylimit.Skylimit.dto.category.CategoryAddCategoryResponseDTO;
import com.skylimit.Skylimit.dto.category.CategoryGetCategoryResponseDTO;
import com.skylimit.Skylimit.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryAddCategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setSlug(dto.getSlug());
        category.setParentId(dto.getParentId());
        category.setLevel(dto.getLevel());
        category.setDisplayOrder(dto.getDisplayOrder());

        // handle active default
        category.setActive(dto.getActive() != null ? dto.getActive() : true);
        return category;
    }

    public CategoryAddCategoryResponseDTO toCreateResponse(Category category) {
        return new CategoryAddCategoryResponseDTO(category.getId(), category.getName(), category.getSlug(), category.getParentId(), category.getLevel(), category.getDisplayOrder(), category.getActive(), category.getCreatedAt(), category.getUpdatedAt());
    }

    public CategoryGetCategoryResponseDTO toDetailsResponse(Category category) {
        return new CategoryGetCategoryResponseDTO(category.getId(), category.getName(), category.getSlug(), category.getParentId(), category.getLevel(), category.getDisplayOrder(), category.getActive());
    }
}

package com.skylimit.Skylimit.dto.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryAddCategoryRequestDTO {
    @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "slug is required")
    private String slug;

    private Long parentId;

    @NotNull(message = "Level is required")
    @Positive(message = "Level must be positive value")
    private int level;

    @NotNull(message = "Display order is required")
    @Positive(message = "Display order must be positive")
    private int displayOrder = 0;

    private Boolean active = true;
}


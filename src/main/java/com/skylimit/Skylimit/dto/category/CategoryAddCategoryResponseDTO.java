package com.skylimit.Skylimit.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CategoryAddCategoryResponseDTO {

    private Long id;

    private String name;

    private String slug;

    private Long parentId;

    private int level;

    private int displayOrder = 0;

    private Boolean active = true;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}


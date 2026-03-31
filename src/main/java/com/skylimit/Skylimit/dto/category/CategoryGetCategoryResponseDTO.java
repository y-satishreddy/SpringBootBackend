package com.skylimit.Skylimit.dto.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryGetCategoryResponseDTO {

    private Long id;
    private String name;

    private String slug;

    private Long parentId;

    private int level;

    private int displayorder = 0;

    private Boolean active;
}

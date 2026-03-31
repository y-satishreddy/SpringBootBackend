package com.skylimit.Skylimit.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="product_id",nullable=false)
    private Long productId;

    @Column(name="image_url",nullable = false)
    private String imageUrl;

    @Column(name="is_primary",nullable=false)
    private Boolean primary=false;

    @Column(name="display_order", nullable=false)
    private int displayOrder = 0;

    @Column(name="created_at", updatable=false, insertable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", updatable=false, insertable = false)
    private LocalDateTime updatedAt;
}

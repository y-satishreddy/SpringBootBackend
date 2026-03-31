package com.skylimit.Skylimit.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name", nullable=false, length = 255)
    private String name;

    @Column(name="slug", nullable = false, length = 255, unique=true)
    private String slug;

    @Column(name="parent_id", nullable = true)
    private Long parentId;

    @Column(name="level", nullable = false)
    private int level;

    @Column(name="display_order", nullable=false)
    private int displayOrder=0;

    @Column(name="is_active", nullable=false)
    private Boolean active=true;

    @Column(name="created_at",nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt;
}


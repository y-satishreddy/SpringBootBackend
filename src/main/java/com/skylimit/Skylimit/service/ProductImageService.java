package com.skylimit.Skylimit.service;

import com.skylimit.Skylimit.entity.ProductImage;
import com.skylimit.Skylimit.repository.ProductImageRepository;

public interface ProductImageService {
    public ProductImage saveProductImage(ProductImage productImage);
    public ProductImage getProductImage(Long id);
}

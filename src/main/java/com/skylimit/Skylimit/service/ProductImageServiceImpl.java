package com.skylimit.Skylimit.service;

import com.skylimit.Skylimit.entity.ProductImage;
import com.skylimit.Skylimit.repository.ProductImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepository productImageRepository;
    public ProductImageServiceImpl(ProductImageRepository productImageRepository){
        this.productImageRepository=productImageRepository;
    }
    public ProductImage saveProductImage(ProductImage productImage){
        return productImageRepository.save(productImage);
    }

    public ProductImage getProductImage(Long id){
        return productImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product image not found"));
    }

}

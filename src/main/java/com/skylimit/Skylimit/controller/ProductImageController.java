package com.skylimit.Skylimit.controller;

import com.skylimit.Skylimit.entity.ProductImage;
import com.skylimit.Skylimit.service.ProductImageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-image")
public class ProductImageController {

    private final ProductImageServiceImpl productImageServiceImpl;

    public ProductImageController(ProductImageServiceImpl productImageServiceImpl){
        this.productImageServiceImpl = productImageServiceImpl;
    }
    @PostMapping
    public ProductImage saveProductImage(@RequestBody ProductImage productImage){
        return productImageServiceImpl.saveProductImage(productImage);
    }

    @GetMapping("/{id}")
    public ProductImage getProductById(@PathVariable Long id){
        return productImageServiceImpl.getProductImage(id);
    }

}

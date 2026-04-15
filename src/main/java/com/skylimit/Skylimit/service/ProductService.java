package com.skylimit.Skylimit.service;

import com.skylimit.Skylimit.dto.product.ProductAddProductRequestDTO;
import com.skylimit.Skylimit.dto.product.ProductAddProductResponseDTO;
import com.skylimit.Skylimit.dto.product.ProductGetProductResponseDTO;

public interface ProductService {
    public ProductAddProductResponseDTO saveProduct(ProductAddProductRequestDTO productDTO);
    public ProductGetProductResponseDTO getProduct(Long id);
    public ProductGetProductResponseDTO partialUpdateProduct(Long id, ProductPartialUpdateDTO productPartialUpdateDTO);
}

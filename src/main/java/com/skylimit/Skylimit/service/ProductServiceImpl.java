package com.skylimit.Skylimit.service;

import com.skylimit.Skylimit.dto.product.ProductAddProductRequestDTO;
import com.skylimit.Skylimit.dto.product.ProductAddProductResponseDTO;
import com.skylimit.Skylimit.dto.product.ProductGetProductResponseDTO;
import com.skylimit.Skylimit.entity.Product;
import com.skylimit.Skylimit.exception.ProductNotFoundException;
import com.skylimit.Skylimit.mapper.ProductMapper;
import com.skylimit.Skylimit.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductAddProductResponseDTO saveProduct(ProductAddProductRequestDTO productDTO) {

        Product repoProduct = productRepository.save(productMapper.toEntity(productDTO));
        return productMapper.toAddResponse(repoProduct);
    }

    public ProductGetProductResponseDTO getProduct(Long id) {
        Product repoProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id : " + id));

        return productMapper.toGetDetailsResponse(repoProduct);
    }
    public ProductGetProductResponseDTO partialProductUpdateDTO(Long id, PartialUpdateProductDTO partialUpdateProductDTO){
        Product repoProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id : " + id));

        if(partialUpdateProductDTO.getName()!=null){
            repoProduct.setName(partialUpdateProductDTO.getName());
    }
        if(partialUpdateProductDTO.getSlug()!=null){
        repoproduct.setSlug(partialUpdateProductDTO.getSlug());
        }
        Product updatedProduct=productRepository.save(repoProduct);
        return productMapper.toGetDetailsResponse(updatedProduct);
}

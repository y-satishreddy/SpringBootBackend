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
   public ProductGetProductResponseDTO partialUpdateProduct(
        Long id,
        ProductPartialUpdateDTO dto
) {
    Product repoProduct = productRepository.findById(id)
            .orElseThrow(() ->
                    new ProductNotFoundException("Product not found with id : " + id));

    if (dto.getName() != null) {
        repoProduct.setName(dto.getName());
    }

    if (dto.getSlug() != null) {
        repoProduct.setSlug(dto.getSlug());
    }

    if (dto.getCategoryId() != null) {
        repoProduct.setCategoryId(dto.getCategoryId());
    }

    if (dto.getBrandName() != null) {
        repoProduct.setBrandName(dto.getBrandName());
    }

    if (dto.getPrice() != null) {
        repoProduct.setPrice(dto.getPrice());
    }

    if (dto.getMrp() != null) {
        repoProduct.setMrp(dto.getMrp());
    }

    if (dto.getShortDescription() != null) {
        repoProduct.setShortDescription(dto.getShortDescription());
    }

    if (dto.getLongDescription() != null) {
        repoProduct.setLongDescription(dto.getLongDescription());
    }

    if (dto.getActive() != null) {
        repoProduct.setActive(dto.getActive());
    }

    if (dto.getFeatured() != null) {
        repoProduct.setFeatured(dto.getFeatured());
    }

    Product updatedProduct = productRepository.save(repoProduct);

    return productMapper.toGetDetailsResponse(updatedProduct);
}
}

package com.skylimit.Skylimit.controller;

import com.skylimit.Skylimit.dto.product.ProductAddProductRequestDTO;
import com.skylimit.Skylimit.dto.product.ProductAddProductResponseDTO;
import com.skylimit.Skylimit.dto.product.ProductGetProductResponseDTO;
import com.skylimit.Skylimit.service.ProductService;
import com.skylimit.Skylimit.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping
    public ProductAddProductResponseDTO saveProduct(@Valid @RequestBody ProductAddProductRequestDTO product) {
        logger.info("POST /products called");
        ProductAddProductResponseDTO response = productServiceImpl.saveProduct(product);
        logger.debug("Product is saved successfully with id : {}, name : {}", response.getId(), response.getName());
        logger.info("Product saved successfully with id = {}", response.getId());
        return response;
    }

    @GetMapping("/{id}")
    public ProductGetProductResponseDTO getProduct(@PathVariable Long id) {
        logger.info("GET /products called with ", id);
        logger.debug("Fetching product details for id: {}", id);
        ProductGetProductResponseDTO response = productServiceImpl.getProduct(id);
        logger.info("Product details returned for id = {}", id);
        return response;
    }
   @PatchMapping("/{id}")
public ResponseEntity<ProductGetProductResponseDTO> partialUpdateProduct(
        @PathVariable Long id,
        @RequestBody ProductPartialUpdateDTO productPartialUpdateDTO
) {
    logger.info("PATCH /products called with id = {}", id);

    ProductGetProductResponseDTO response =
            productService.partialUpdateProduct(id, productPartialUpdateDTO);

    logger.info("Product updated successfully with id = {}", id);

    return ResponseEntity.ok(response);
}
    @PutMapping("/{id}")
    public ResponseEntity<ProductGetProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequest produtUpdateRequest){
        logger.info("PUT /products is called with id = {}", id);
        ProductGetProductResponseDTO response=productService.updateProduct(id,productUpdateRequest);
        logger.info("Product updated successfully with id = {}", id);
        return ResponseEntity.ok(response);
    }
}

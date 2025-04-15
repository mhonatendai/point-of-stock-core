package com.tenstech.pointofstock.productcategory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public List<ProductCategoryDTO> getAll() {
        return productCategoryService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getById(@PathVariable Long id) {
        Optional<ProductCategoryDTO> productCategoryDTO = productCategoryService.getById(id);
        return productCategoryDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductCategoryDTO createProduct(@RequestBody ProductCategoryDTO productDTO) {
        return productCategoryService.create(productDTO);
    }

}

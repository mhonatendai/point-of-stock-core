package com.tenstech.pointofstock.productcategory;


import java.util.List;
import java.util.Optional;

public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Override
    public List<ProductCategoryDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public Optional<ProductCategoryDTO> getProductById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductCategoryDTO createProduct(ProductCategoryDTO productCategoryDTO) {
        return null;
    }

    @Override
    public ProductCategoryDTO updateProduct(Long id, ProductCategoryDTO productCategoryDTO) {
        return null;
    }
}

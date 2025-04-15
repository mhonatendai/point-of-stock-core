package com.tenstech.pointofstock.productcategory;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Override
    public List<ProductCategoryDTO> getAll() {
        return List.of();
    }

    @Override
    public Optional<ProductCategoryDTO> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductCategoryDTO create(ProductCategoryDTO productCategoryDTO) {
        return null;
    }

    @Override
    public ProductCategoryDTO update(Long id, ProductCategoryDTO productCategoryDTO) {
        return null;
    }
}

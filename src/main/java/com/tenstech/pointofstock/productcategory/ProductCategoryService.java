package com.tenstech.pointofstock.productcategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

    List<ProductCategoryDTO> getAll();

    Optional<ProductCategoryDTO> getById(Long id);

    ProductCategoryDTO create(ProductCategoryDTO productCategoryDTO);

    ProductCategoryDTO update(Long id, ProductCategoryDTO productCategoryDTO);

}

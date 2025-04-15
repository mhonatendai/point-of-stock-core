package com.tenstech.pointofstock.productcategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {

    List<ProductCategoryDTO> getAllProducts();

    Optional<ProductCategoryDTO> getProductById(Long id);

    ProductCategoryDTO createProduct(ProductCategoryDTO productCategoryDTO);

    ProductCategoryDTO updateProduct(Long id, ProductCategoryDTO productCategoryDTO);

}

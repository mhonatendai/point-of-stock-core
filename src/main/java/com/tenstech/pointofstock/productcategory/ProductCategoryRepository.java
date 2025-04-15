package com.tenstech.pointofstock.productcategory;

import com.tenstech.pointofstock.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}

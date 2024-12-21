package com.tenstech.pointofstock.product;

import com.tenstech.pointofstock.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
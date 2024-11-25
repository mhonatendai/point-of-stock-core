package com.tenstech.shopper.product;

import com.tenstech.shopper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
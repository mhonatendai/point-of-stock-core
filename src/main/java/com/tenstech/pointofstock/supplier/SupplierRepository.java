package com.tenstech.pointofstock.supplier;

import com.tenstech.pointofstock.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}

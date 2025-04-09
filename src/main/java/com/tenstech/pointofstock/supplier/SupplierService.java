package com.tenstech.pointofstock.supplier;

import com.tenstech.pointofstock.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<SupplierDTO> findAll();

    Optional<SupplierDTO> findById(Long id);

    SupplierDTO createSupplier(SupplierDTO supplierDTO);

    SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO);

}

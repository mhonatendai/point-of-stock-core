package com.tenstech.pointofstock.supplier;

import com.tenstech.pointofstock.mapper.TypeMapper;
import com.tenstech.pointofstock.model.Product;
import com.tenstech.pointofstock.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final TypeMapper typeMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, TypeMapper typeMapper) {
        this.supplierRepository = supplierRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.save(typeMapper.supplierDTOToSupplier(supplierDTO));
        return typeMapper.supplierToSupplierDTO(supplier);
    }

    @Override
    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier existingSupplier = supplierRepository.findById(id).orElseThrow();
        Supplier updatedSupplierWithData = typeMapper.supplierDTOToSupplier(supplierDTO);
        updatedSupplierWithData.setId(existingSupplier.getId());
        return typeMapper.supplierToSupplierDTO(supplierRepository.save(updatedSupplierWithData));
    }
}

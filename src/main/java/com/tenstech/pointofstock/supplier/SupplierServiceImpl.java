package com.tenstech.pointofstock.supplier;

import com.tenstech.pointofstock.mapper.TypeMapper;
import com.tenstech.pointofstock.model.Product;
import com.tenstech.pointofstock.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final TypeMapper typeMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, TypeMapper typeMapper) {
        this.supplierRepository = supplierRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public List<SupplierDTO> findAll() {
        return supplierRepository.findAll().stream()
                .map(typeMapper::supplierToSupplierDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SupplierDTO> findById(Long id) {
        return supplierRepository.findById(id).map(typeMapper::supplierToSupplierDTO);
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

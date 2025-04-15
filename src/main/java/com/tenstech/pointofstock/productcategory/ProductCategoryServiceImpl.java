package com.tenstech.pointofstock.productcategory;


import com.tenstech.pointofstock.mapper.TypeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    private final TypeMapper typeMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, TypeMapper typeMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public List<ProductCategoryDTO> getAll() {
        return productCategoryRepository.findAll().stream()
                .map(typeMapper::productCategoryToProductCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductCategoryDTO> getById(Long id) {
        return productCategoryRepository.findById(id).map(typeMapper::productCategoryToProductCategoryDTO);
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

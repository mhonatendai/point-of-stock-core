package com.tenstech.pointofstock.product;

import com.tenstech.pointofstock.mapper.TypeMapper;
import com.tenstech.pointofstock.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final TypeMapper typeMapper;

    public ProductServiceImpl(ProductRepository productRepository, TypeMapper typeMapper) {
        this.productRepository = productRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(typeMapper::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id).map(typeMapper::productToProductDTO);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product savedProduct = productRepository.save(typeMapper.productDTOToProduct(productDTO));
        return typeMapper.productToProductDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        log.info("Updating product with id {} to product {}", id, productDTO);
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSellingPrice(productDTO.getPrice());
        Product updatedProduct = productRepository.save(product);
        return typeMapper.productToProductDTO(updatedProduct);
    }

}
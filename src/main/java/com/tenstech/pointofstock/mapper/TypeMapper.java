package com.tenstech.pointofstock.mapper;

import com.tenstech.pointofstock.model.Product;
import com.tenstech.pointofstock.model.ProductCategory;
import com.tenstech.pointofstock.model.Supplier;
import com.tenstech.pointofstock.model.User;
import com.tenstech.pointofstock.product.ProductDTO;
import com.tenstech.pointofstock.productcategory.ProductCategoryDTO;
import com.tenstech.pointofstock.supplier.SupplierDTO;
import com.tenstech.pointofstock.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    @Mapping(target = "password", ignore = true)
    UserDto userToUserDTO(User user);

    @Mapping(target = "password", ignore = true)
    User userDTOToUser(UserDto userDTO);

    Supplier supplierDTOToSupplier(SupplierDTO supplierDTO);

    @Mapping(source = "id", target = "id")
    SupplierDTO supplierToSupplierDTO(Supplier supplier);

    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);

    ProductCategoryDTO productCategoryToProductCategoryDTO(ProductCategory productCategory);

    ProductCategory productCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO);
}
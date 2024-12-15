package com.tenstech.shopper.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

}
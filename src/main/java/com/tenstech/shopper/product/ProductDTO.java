package com.tenstech.shopper.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;

}
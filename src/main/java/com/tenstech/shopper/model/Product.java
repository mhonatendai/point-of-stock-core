package com.tenstech.shopper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends AuditedEntity {

    private String name;
    private String description;
    private double price;

}
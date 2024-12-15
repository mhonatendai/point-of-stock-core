package com.tenstech.shopper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends AuditedEntity {

    private String name;
    private String description;
    private double price;

}
package com.tenstech.shopper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Product extends AuditedEntity {

    @Column
    private String name;

    @Column
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;
    private String stockKeepingUnit;
    private String barcode;
}
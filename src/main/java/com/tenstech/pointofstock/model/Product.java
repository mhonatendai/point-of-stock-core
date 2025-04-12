package com.tenstech.pointofstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column
    private BigDecimal purchasePrice;

    @Column
    private BigDecimal sellingPrice;

    @Column
    private String barcode;

    @Column
    private boolean active = true;
}
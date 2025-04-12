package com.tenstech.pointofstock.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class PointOfSaleItem extends AuditedEntity{

    @ManyToOne
    @JoinColumn(name = "pos_transaction_id", nullable = false)
    private PointOfSaleTransaction posTransaction;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal sellingPrice;

    private BigDecimal discount;

    private String notes;
}
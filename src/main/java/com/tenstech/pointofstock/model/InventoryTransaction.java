package com.tenstech.pointofstock.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class InventoryTransaction extends AuditedEntity {

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantityChange;

    @Column(nullable = false)
    private LocalDateTime transactionDate = LocalDateTime.now();

    private String transactionType;

    private String referenceNumber;

    private String notes;

}
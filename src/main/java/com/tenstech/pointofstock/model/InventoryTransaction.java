package com.tenstech.pointofstock.model;

import com.tenstech.pointofstock.common.enums.TransactionType;
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

    @Column
    private String transactionType;

    private String referenceNumber;

    private String notes;

    @PrePersist
    @PreUpdate
    private void setTransactionTypeValue() {
        if (this.transactionTypeEnum != null) {
            this.transactionType = this.transactionTypeEnum.getName();
        }
    }

    @Transient
    private TransactionType transactionTypeEnum;

    public void setTransactionTypeEnum(TransactionType transactionTypeEnum) {
        this.transactionTypeEnum = transactionTypeEnum;
        if (transactionTypeEnum != null) {
            this.transactionType = transactionTypeEnum.getName();
        }
    }

}
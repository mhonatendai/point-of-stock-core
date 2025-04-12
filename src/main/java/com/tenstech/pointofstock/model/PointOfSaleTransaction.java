package com.tenstech.pointofstock.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class PointOfSaleTransaction extends AuditedEntity{

    @Column(nullable = false, unique = true)
    private String transactionNumber;

    private LocalDateTime transactionDate = LocalDateTime.now();

    @OneToMany(mappedBy = "posTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PointOfSaleItem> saleItems;

    private String customerName;

    private String customerEmail;

    private String paymentMethod;

    private String notes;

}
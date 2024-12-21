package com.tenstech.shopper.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Batch extends AuditedEntity{

    @Column
    private String batchNumber;

    @Column
    private LocalDate batchReceivedDate;

    @Column
    private String batchStatus;

    @Column
    private BigDecimal batchPrice;

    @Column
    private int quantity;

    @Column
    private LocalDate expiryDate;

    @ManyToOne
    private Product product;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;
}
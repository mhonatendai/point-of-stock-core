package com.tenstech.pointofstock.model;

import com.tenstech.pointofstock.common.enums.BatchStatus;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    @Column
    private BatchStatus batchStatus;

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
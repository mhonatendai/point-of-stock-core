package com.tenstech.shopper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Batch extends AuditedEntity{

    private int quantity;

    private LocalDate expiryDate;

    @ManyToOne
    private Product product;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;
}
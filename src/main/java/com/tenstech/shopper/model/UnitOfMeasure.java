package com.tenstech.shopper.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UnitOfMeasure extends AuditedEntity{

    private String name;
    private String description;
    private String unit;
}
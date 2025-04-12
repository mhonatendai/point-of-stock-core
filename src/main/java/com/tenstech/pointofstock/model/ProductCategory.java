package com.tenstech.pointofstock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ProductCategory extends AuditedEntity{

    @Column
    private String name;

    @Column
    private String description;
}

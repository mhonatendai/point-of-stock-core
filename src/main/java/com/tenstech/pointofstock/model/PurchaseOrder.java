package com.tenstech.pointofstock.model;

import com.tenstech.pointofstock.common.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class PurchaseOrder extends AuditedEntity{

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    private LocalDate orderDate = LocalDate.now();

    private LocalDate expectedDeliveryDate;

    private LocalDate deliveryDate;

    private String shippingAddress;

    private String billingAddress;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> orderItems;

    private String notes;
}
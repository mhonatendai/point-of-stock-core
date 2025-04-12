package com.tenstech.pointofstock.common.enums;

public enum TransactionType {

    PURCHASE("Purchase"),
    SALE("Sale"),
    ADJUSTMENT("Adjustment"),
    RETURN("Return"),
    TRANSFER("Transfer");

    private final String name;

    TransactionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static TransactionType fromName(String displayName) {
        for (TransactionType type : TransactionType.values()) {
            if (type.name.equalsIgnoreCase(displayName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No TransactionType found with name: " + displayName);
    }
}

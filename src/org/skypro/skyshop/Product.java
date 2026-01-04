package org.skypro.skyshop;

public abstract class Product {
    private final String productName;

    Product(String productName) {
        this.productName = productName;
    }

    String getProductName() {
        return productName;
    }

    abstract int getPrice();

    boolean isSpecial() {
        return false;
    }
}
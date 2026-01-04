package org.skypro.skyshop;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
    }

    @Override
    int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return getProductName() + ": " + getPrice();
    }
}
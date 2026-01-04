package org.skypro.skyshop;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String productName, int basePrice, int discountPercent) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    int getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    @Override
    boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + " (" + discountPercent + " %)";
    }
}
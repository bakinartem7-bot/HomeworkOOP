package org.skypro.skyshop;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final double discountPercent;

    public DiscountedProduct(String productName, int basePrice, double discountPercent) {
        super(productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть строго больше 0 (получено: " + basePrice + ")");
        }

        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне [0, 100] (получено: " + discountPercent + "%)");
        }
    private final int discountPercent;

    public DiscountedProduct(String productName, int basePrice, int discountPercent) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice * (1 - discountPercent / 100));
    int getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    @Override
    boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + " (" + (int)discountPercent + " %)";
        return getProductName() + ": " + getPrice() + " (" + discountPercent + " %)";
    }
}
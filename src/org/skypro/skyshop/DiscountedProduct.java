package org.skypro.skyshop;

class DiscountedProduct extends Product {
    private final int basePrice;
    private final double discountPercent;

    public DiscountedProduct(String productName, int basePrice, double discountPercent) {
        super(productName);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice * (1 - discountPercent / 100));
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + " (" + (int)discountPercent + " %)";
    }
}
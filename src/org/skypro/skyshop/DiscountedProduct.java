package org.skypro.skyshop;

public class DiscountedProduct extends Product {
    private final int discountPercent;

    public DiscountedProduct(String name, int price, int discountPercent) {
        super(name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public String getStringRepresentation() {
        int discountedPrice = price - (price * discountPercent / 100);
        return productName + " (скидка " + discountPercent + "%) : " + discountedPrice + " руб.";
    }
}
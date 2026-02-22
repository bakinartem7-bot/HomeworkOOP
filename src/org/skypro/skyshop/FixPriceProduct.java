package org.skypro.skyshop;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 99;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE);
    }

    @Override
    public String getStringRepresentation() {
        return productName + " : " + FIXED_PRICE + " руб. (фиксированная цена)";
    public String toString() {
        return getProductName() + ": Фиксированная цена " + getPrice();
    int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    boolean isSpecial() {
        return true;
    }

    @Override  // Явно указываем переопределение
    public String toString() {
        return getProductName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
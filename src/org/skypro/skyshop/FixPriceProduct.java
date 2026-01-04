package org.skypro.skyshop;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 99;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
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
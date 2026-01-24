package org.skypro.skyshop;

public class FixPriceProduct extends Product {
    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return 99;
    }

    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + getPrice();
    }
}
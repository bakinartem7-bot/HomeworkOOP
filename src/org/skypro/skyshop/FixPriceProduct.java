package org.skypro.skyshop;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 99;

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE);
    }

    @Override
    public String getStringRepresentation() {
        return productName + " : " + FIXED_PRICE + " руб. (фиксированная цена)";
    }
}
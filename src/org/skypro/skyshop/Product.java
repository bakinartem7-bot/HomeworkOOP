package org.skypro.skyshop;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    abstract int getPrice();

    boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return productName;
    }
}
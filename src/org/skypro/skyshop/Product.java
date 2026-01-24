package org.skypro.skyshop;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть null или пустым (включая пробелы)");
        }
public abstract class Product {
    private final String productName;

    Product(String productName) {
        this.productName = productName;
    }

    String getProductName() {
        return productName;
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
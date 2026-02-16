package org.skypro.skyshop;

import java.util.Objects;

public abstract class Product implements Searchable {
    protected String productName;
    protected int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getSearchTerm() {
        return productName + " " + price;
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public String getStringRepresentation() {
        return productName + ": " + price + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
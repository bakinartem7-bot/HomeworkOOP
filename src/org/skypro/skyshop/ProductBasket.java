package org.skypro.skyshop;

import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private final List<Product> items = new LinkedList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new LinkedList<>();

        // Используем Iterator для безопасного удаления во время обхода
        var iterator = items.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                iterator.remove();
                removed.add(product);
            }
    private static final int MAX_ITEMS = 5;
    private int count = 0;
    private Product[] items = new Product[MAX_ITEMS];

    public void addProduct(Product product) {
        if (count >= MAX_ITEMS) {
            System.out.println("Невозможно добавить продукт.");
            return;
        }

        return removed;
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : items) {
            total += product.getPrice();
        for (int i = 0; i < count; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public void printContents() {
        if (items.isEmpty()) {
        int specialCount = 0;

        if (count == 0) {
            System.out.println("В корзине пусто.");
        } else {
            for (int i = 0; i < count; i++) {
                Product product = items[i];
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        for (Product product : items) {
            System.out.println(product.getProductName() + ": " + product.getPrice());
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String productName) {
        for (Product product : items) {
            if (product.getProductName().equals(productName)) {
        for (int i = 0; i < count; i++) {
            if (items[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        items.clear();
    }
}
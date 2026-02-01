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
        }

        return removed;
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }

    public void printContents() {
        if (items.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        for (Product product : items) {
            System.out.println(product.getProductName() + ": " + product.getPrice());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean hasProduct(String productName) {
        for (Product product : items) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        items.clear();
    }
}
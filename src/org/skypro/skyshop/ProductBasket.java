package org.skypro.skyshop;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProductName(), k -> new ArrayList<>())
                .add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : Collections.emptyList();
    }

    public int getTotalCost() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printContents() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        List<String> sortedKeys = new ArrayList<>(products.keySet());
        Collections.sort(sortedKeys);

        for (String name : sortedKeys) {
            List<Product> productList = products.get(name);
            for (Product product : productList) {
                System.out.println(product.getProductName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean hasProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clear() {
        products.clear();
    }
}
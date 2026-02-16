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
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        for (Product product : items) {
            total += product.getPrice();
        for (int i = 0; i < count; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public void printContents() {
        if (products.isEmpty()) {
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

        List<String> sortedKeys = new ArrayList<>(products.keySet());
        Collections.sort(sortedKeys);

        for (String name : sortedKeys) {
            List<Product> productList = products.get(name);
            for (Product product : productList) {
                System.out.println(product.getProductName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String productName) {
        return products.containsKey(productName);
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
        products.clear();
    }
}
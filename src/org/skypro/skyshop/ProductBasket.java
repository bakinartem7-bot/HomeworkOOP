package org.skypro.skyshop;

import java.util.*;
import java.util.stream.Collectors;

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
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printContents() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто.");
            return;
        }

        products.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator
                        .comparing(Product::getProductName)
                        .thenComparingInt(Product::getPrice))
                .forEach(product -> {
                    String repr = product.getStringRepresentation();
                    System.out.println(repr != null ? repr : "Неизвестный продукт");
                });

        System.out.println("Итого: " + getTotalCost());
    }

    public boolean hasProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clear() {
        products.clear();
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(this::isSpecialProduct)
                .count();
    }

    private boolean isSpecialProduct(Product product) {
        return product.getPrice() > 100;
    }
}

package org.skypro.skyshop;

public class ProductBasket {
    private static final int MAX_ITEMS = 5;
    private int count = 0;
    private Product[] items = new Product[MAX_ITEMS];

    public void addProduct(Product product) {
        if (count >= MAX_ITEMS) {
            System.out.println("Невозможно добавить продукт.");
            return;
        }
        items[count] = product;
        count++;
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    public void printContents() {
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

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (items[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < count; i++) {
            items[i] = null;
        }
        count = 0;
    }
}
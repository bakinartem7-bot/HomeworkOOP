package org.skypro.skyshop;

public class ProductBasket {
    private int count = 0;
    private static final int MAX_Items = 5;
    private Product[] items = new Product[MAX_Items];

    public  void addProduct(Product product) {
        if (count >= MAX_Items){
            System.out.println(" Невозможно добавить продукт.");
            return;
        }
        items[count] = product;
        count++;
    }

    public int getTotalCost() {
        int total = 0;
        for ( int i = 0; i < count; i++){
            total += items[i].getPrice();
        }
        return total;
    }

    public void printContents() {
        if (count == 0) {
            System.out.println("В корзине пусто.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(items[i].getProductName() + ": " + items[i].getPrice());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean hasProduct (String productName) {
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

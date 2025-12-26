package org.skypro.skyshop;

public class ProductBasket {
    private int count = 0;
    private int MAX_Items = 5;
    private Product[] items = new Product[MAX_Items];

    public  void addproduct(Product product) {
        if (count > MAX_Items){
            System.out.println(" Невозможно добавить продукт");
        }
        return;
    }

    public int totalCost() {
        int total = 0;
        for ( int i = 0;i < count; i++){
            total += items[i].getPrice();

        }
        return total;
    }

    public void printBaskets() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        for (int i = count; i < count; i++) {
            System.out.println(items[i].getProductName() + items[i].getPrice());
        }
        System.out.println("Итого " + totalCost());
    }

    public boolean basketFullness (String name) {
        for (int i = 0; i < count; i++) {
            if (items[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

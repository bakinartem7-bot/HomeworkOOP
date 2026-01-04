package org.skypro.skyshop;

public class App {
    public static void main (String[] args) {
        Product apple = new SimpleProduct("Яблоко", 150);
        Product banana = new DiscountedProduct("Банан", 200, 25);
        Product pear = new FixPriceProduct("Груша");
        Product strawberry = new SimpleProduct("Клубника", 120);
        Product water = new DiscountedProduct("Вода", 50, 10);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(pear);
        basket.addProduct(strawberry);
        basket.addProduct(water);

        basket.printContents();

        System.out.println("Общая стоимость: " + basket.getTotalCost() + " руб.");
        System.out.println("Есть ли яблоко в корзине? " + basket.hasProduct("Яблоко"));
        System.out.println("Есть ли банан в корзине? " + basket.hasProduct("Банан"));

        basket.clear();
        basket.printContents();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost() + " руб.");
    }
}
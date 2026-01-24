package org.skypro.skyshop;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        try {
            Product invalidName = new SimpleProduct("   ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    public static void main (String[] args) {
        Product apple = new SimpleProduct("Яблоко", 150);
        Product banana = new DiscountedProduct("Банан", 200, 25);
        Product pear = new FixPriceProduct("Груша");
        Product strawberry = new SimpleProduct("Клубника", 120);
        Product water = new DiscountedProduct("Вода", 50, 10);

        try {
            Product zeroPrice = new SimpleProduct("Яблоко", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product negativeDiscount = new DiscountedProduct("Банан", 200, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product overDiscount = new DiscountedProduct("Груша", 150, 110);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== 2. Создание корректных объектов ===\n");

        Product apple = new SimpleProduct("Яблоко", 150);
        Product banana = new DiscountedProduct("Банан", 200, 25);
        Product pear = new FixPriceProduct("Груша");
        Product strawberry = new SimpleProduct("Клубника", 120);
        Product water = new DiscountedProduct("Вода", 50, 10);

        Article article1 = new Article("Как выбрать яблоки", "Советы по выбору лучших яблок.");
        Article article2 = new Article("Польза бананов", "Бананы содержат калий и витамины.");
        Article article3 = new Article("Секреты выращивания клубники", "Как получить богатый урожай клубники.");

        System.out.println("Созданы продукты и статьи.\n");

        System.out.println("=== 3. Работа с корзиной товаров ===\n");


        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(pear);
        basket.addProduct(strawberry);
        basket.addProduct(water);
        basket.printContents();

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(pear);
        searchEngine.add(strawberry);
        searchEngine.add(water);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println("--- Поиск по запросу 'яблок':");
        System.out.println(Arrays.toString(searchEngine.search("яблок")));

        System.out.println("--- Поиск по запросу 'банан':");
        System.out.println(Arrays.toString(searchEngine.search("банан")));


        System.out.println("--- Поиск по запросу 'клубник':");
        System.out.println(Arrays.toString(searchEngine.search("клубник")));


        System.out.println("--- Поиск по запросу 'вода':");
        System.out.println(Arrays.toString(searchEngine.search("вода")));

        try {
            Searchable best = searchEngine.findBestMatch("красные");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        try {
            Searchable best = searchEngine.findBestMatch("экзотический");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        try {
            Searchable best = searchEngine.findBestMatch("");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        basket.printContents();

        System.out.println("Общая стоимость: " + basket.getTotalCost() + " руб.");
        System.out.println("Есть ли яблоко в корзине? " + basket.hasProduct("Яблоко"));
        System.out.println("Есть ли банан в корзине? " + basket.hasProduct("Банан"));

        basket.clear();
        basket.printContents();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost() + " руб.");
    }
}
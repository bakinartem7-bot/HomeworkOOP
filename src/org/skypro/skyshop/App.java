package org.skypro.skyshop;

import java.util.List;


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

        System.out.println("=== 1. Изначальное содержимое корзины ===");
        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(pear);
        basket.addProduct(strawberry);
        basket.addProduct(water);
        basket.printContents();

        System.out.println("=== 2. Удаление продукта 'Банан' из корзины ===");
        List<Product> removedBananas = basket.removeProductsByName("Банан");


        if (!removedBananas.isEmpty()) {
            System.out.println("Удалённые продукты:");
            for (Product p : removedBananas) {
                System.out.println("- " + p.getProductName() + " (цена: " + p.getPrice() + ")");
            }
        } else {
            System.out.println("Список пуст");
        }

        System.out.println("Содержимое корзины после удаления:");
        basket.printContents();

        System.out.println("=== 3. Удаление продукта 'Манго' (не существует) ===");
        List<Product> removedMango = basket.removeProductsByName("Манго");

        if (removedMango.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалённые продукты:");
            for (Product p : removedMango) {
                System.out.println("- " + p.getProductName());
            }
        }

        System.out.println("Содержимое корзины:");
        basket.printContents();

        System.out.println("=== 4. Поиск в SearchEngine ===");
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(pear);
        searchEngine.add(strawberry);
        searchEngine.add(water);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        String[] queries = {"яблок", "банан", "клубник", "вода", "секрет"};


        for (String query : queries) {
            System.out.println("--- Поиск по запросу '" + query + "':");
            List<Searchable> results = searchEngine.search(query);


            if (results.isEmpty()) {
                System.out.println("Ничего не найдено.");
            } else {
                for (Searchable item : results) {
                    System.out.println("  • " + item.getStringRepresentation());
                }
            }
        }

        System.out.println("=== 5. Поиск лучшего совпадения ===");

        String[] bestMatchQueries = {"красные", "экзотический", ""};


        for (String search : bestMatchQueries) {
            try {
                Searchable best = searchEngine.findBestMatch(search);
                System.out.println("Лучший результат для запроса '" + search + "': " + best.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println("Ошибка поиска для запроса '" + search + "': " + e.getMessage());
            }
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
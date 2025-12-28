import org.skypro.skyshop.Product;
import org.skypro.skyshop.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 150);
        Product banana = new Product("Банан", 140);
        Product pear = new Product("Груша", 80);
        Product strawberry = new Product("Клубника", 120);
        Product water = new Product("Вода", 20);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(pear);

        basket.addProduct(strawberry);
        basket.addProduct(water);
        basket.addProduct(new Product("Груша", 80));

        basket.printContents();

        System.out.println("Общая стоимость: " + basket.getTotalCost() + " руб.");

        System.out.println("Есть ли яблоко в корзине? " + basket.hasProduct("Яблоко"));

        System.out.println("Есть ли банан в корзине? " + basket.hasProduct("Банан"));

        basket.clear();

        basket.printContents();

        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost() + " руб.");
        
        System.out.println("Есть ли груша в пустой корзине? " + basket.hasProduct("Груша"));
    }
}

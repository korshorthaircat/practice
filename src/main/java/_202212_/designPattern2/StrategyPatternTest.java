package _202212_.designPattern2;

import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    public void pay(int amount);
}

class KakaoCardStrategy implements PaymentStrategy{
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public KakaoCardStrategy(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using KakaoCard.");
    }
}

class NaverCardStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    public NaverCardStrategy(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using NaverCard.");
    }
}

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class ShoppingCart {
    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}


public class StrategyPatternTest {
    public static void main (String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item itemA = new Item("iphone", 100);
        Item itemB = new Item("macbook", 200);

        cart.addItem(itemA);
        cart.addItem(itemB);

        cart.pay(new NaverCardStrategy("korshort@gmail.com", "1234"));
        //cart.pay(new KakaoCardStrategy("korshort", "12345678", "123", "12/25"));

    }
}

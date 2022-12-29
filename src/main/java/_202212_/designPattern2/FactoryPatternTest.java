package _202212_.designPattern2;

abstract class Coffee {
    public abstract int getPrice();

    @Override
    public String toString() {
        return "Hi, this coffee is " + this.getPrice();
    }
}

class TodayCoffee extends Coffee {
    private int price;

    public TodayCoffee() {
        this.price = -1;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

class Latte extends Coffee {
    private int price;

    public Latte(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

class Americano extends Coffee {
    private int price;

    public Americano(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

class CoffeeFactory {
    public static Coffee getCoffee(String type, int price) {
        if ("Latte".equalsIgnoreCase(type)) { //Enum 또는 Map을 이용해 if문을 쓰지않고 매핑해서 로직을 구성할 수도 있음
            return new Latte(price);
        }
        else if ("Americano".equalsIgnoreCase(type)) {
            return new Americano(price);
        }
        else {
            return new TodayCoffee();
        }

    }
}

public class FactoryPatternTest {
    public static void main (String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee americano = CoffeeFactory.getCoffee("Americano", 3000);

        System.out.println("Factory Latte: " + latte);
        System.out.println("Factory Americano: " + americano);
    }
}

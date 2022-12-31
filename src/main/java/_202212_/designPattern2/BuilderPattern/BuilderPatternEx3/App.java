package _202212_.designPattern2.BuilderPattern.BuilderPatternEx3;


import static _202212_.designPattern2.BuilderPattern.BuilderPatternEx3.NewYorkPizza.Size.*;
import static _202212_.designPattern2.BuilderPattern.BuilderPatternEx3.Pizza.Topping.*;

public class App {
    public static void main (String[] args) {
        NewYorkPizza pizza = new NewYorkPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();
    }
}

package _202302_;

import java.util.function.*;

public class JavaUtilFunctionTest {
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("Hello:)");
        runnable.run();

        Supplier<Integer> supplier = () -> (int)(Math.random() * 6 + 1);
        System.out.println("random dice number = " + supplier.get());

        Consumer<String> consumer = (name) -> System.out.println("His name is " + name);
        consumer.accept("gogo");

        Function<Integer, Integer> function = a -> a * a;
        System.out.println(function.apply(5));

        Predicate<Integer> predicate = num -> num % 2 == 0 ?  true : false ;
        System.out.println("even number? " + predicate.test(8));

        BiConsumer<String, String> biConsumer = (name, age) -> System.out.println(name + " is " + age + " years old.");
        biConsumer.accept("gogo", "7");

        BiFunction<Integer, Integer, Double> biFunction = (Integer num1, Integer num2) -> {
            return num1 * 10 / 10.0 / num2 ;
        };
        System.out.println(biFunction.apply(35, 8));

        BiPredicate<Integer, Integer> biPredicate = (num1, num2) -> num1 > num2 ? true : false;
        System.out.println(biPredicate.test(8, 5));
    }
}

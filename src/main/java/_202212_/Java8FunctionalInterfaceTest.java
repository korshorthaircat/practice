package _202212_;

import java.util.function.*;

public class Java8FunctionalInterfaceTest {
    public static void main (String[] args) {

        Runnable runnable = () -> System.out.println("hello");
        runnable.run();
        //Runnable 인터페이스 - 실행할 수 있는 인터페이스
        //void run()

        Supplier<Integer> supplier = () -> 3 * 3;
        System.out.println(supplier.get());
        //Supplier<T> 인터페이스 - 제공할 수 있는 인터페이스
        //T get()

        Consumer<Integer> consumer = num -> System.out.println(num);
        consumer.accept(123);
        //Consumer<T> 인터페이스 - 소비할 수 있는 인터페이스
        //void accept(T t)

        Function<Integer, String> function = num -> "num: " + num;
        System.out.println(function.apply(456));
        //Function<T, R> 인터페이스 - 입력을 받아서 출력할 수 있는 인터페이스
        //R apply(T t)

        Predicate<Integer> predicate = num -> num > 10;
        System.out.println(predicate.test(20));
        //Predicate<T> 인터페이스 - 입력을 받아 참,거짓을 단정할 수 있는 인터페이스
        //Boolean test(T t)

        UnaryOperator<Integer> unaryOperator = num -> num * num;
        System.out.println(unaryOperator.apply(10));
        //UnaryOperator<T> 인터페이스 - 단항 연산을 할 수 있는 인터페이스
        //T apply(T t)

        BiConsumer<String, Integer> biConsumer = (str, num) -> System.out.println(str + num);
        biConsumer.accept("안녕하세요", 123);
        //BiConsumer<T, U> 인터페이스 - 이항소비자 인터페이스
        //void accept(T t, U u)

        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "str: " + num1 + num2;
        System.out.println(biFunction.apply(123, 456));
        //BiFunction<T, U, R> 인터페이스 - 이항함수 인터페이스
        //R apply(T t, U u)

        BiPredicate<Integer, Integer> biPredicate = (num1, num2) -> num1 > num2;
        System.out.println(biPredicate.test(3,5));
        //BiPredicate<T, U> 인터페이스 - 이항 단정 인터페이스
        //Boolean test(T t, U u)

        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 - num2;
        System.out.println(binaryOperator.apply(3,4));
        //BinaryOperator<T, T> 인터페이스 - 이항 연산 인터페이스
        //T apply(T t, U u)
    }
}

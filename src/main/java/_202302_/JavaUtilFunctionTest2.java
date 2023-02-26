package _202302_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class JavaUtilFunctionTest2 {
    //지네릭타입을 사용하는 함수형 인터페이스와 기본형을 사용하는 함수형 인터페이스 비교
    public static void main(String[] args) {

        //1) 지네릭타입을 사용하는 함수형인터페이스
        Supplier<Integer> supplier = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> consumer = num -> System.out.print(num + ", ");
        Predicate<Integer> predicate = num -> num % 2 == 0;
        Function<Integer, Integer> function = num -> num / 10 * 10;

        //2) 기본타입을 사용하는 함수형인터페이스
        IntSupplier intSupplier = () -> (int)(Math.random() * 100) + 1;
        IntConsumer intConsumer = num -> System.out.print(num + ", ");
        IntPredicate intPredicate = num -> num % 2 ==0;
        IntUnaryOperator intUnaryOperator = num -> num * 10 / 10;



        List<Integer> list = new ArrayList<>();
        makeRandomList1(supplier, list);
        System.out.println(list);

        printEvenNum1(predicate, consumer, list);

        List<Integer> newList = doSomething1(function, list);
        System.out.println(newList);
        System.out.println("/////////////////////");

        int[] arr = new int[10];
        makeRandomList2(intSupplier, arr);
        System.out.println(Arrays.toString(arr));

        printEvenNum2(intPredicate, intConsumer, arr);

        int[] newArr = doSomething2(intUnaryOperator, arr);
        System.out.println(Arrays.toString(newArr));


    }

    static <T> List<T> doSomething1(Function<T, T> function, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());
        for (T i : list) {
           newList.add(function.apply(i));
        }
        return newList;
    }

    static int[] doSomething2(IntUnaryOperator intUnaryOperator, int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = intUnaryOperator.applyAsInt(arr[i]); //apply()가 아니라, applyAsInt()임에 유의
        }
        return newArr;
    }

    static <T> void printEvenNum1(Predicate<T> predicate, Consumer<T> consumer, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (predicate.test(i)) {
                consumer.accept(i);
            }
        }
        System.out.println("]");
    }

    static void printEvenNum2(IntPredicate intPredicate, IntConsumer intConsumer, int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            if(intPredicate.test(i)) {
                intConsumer.accept(i);
            }
        }
        System.out.println("]");
    }

    static <T> void makeRandomList1(Supplier<T> supplier, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(supplier.get());
        }
    }

    static void makeRandomList2(IntSupplier intSupplier, int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = intSupplier.getAsInt(); //getAsInt() 유의
        }
    }
}

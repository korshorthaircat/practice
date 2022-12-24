package _202212_;

import java.util.Arrays;

public class Stream002 {
    public static void main(String[] args) {

        Integer[] ages = {29, 23, 45, 12, 10, 18, 19, 56, 23, 56, 34, 23, 56, 23, 45, 67, 78};

        System.out.println(Arrays.stream(ages).count());

        System.out.println(Arrays.stream(ages).mapToInt(age -> age).sum());
        System.out.println(Arrays.stream(ages).mapToInt(age -> age).average());
        System.out.println(Arrays.stream(ages).mapToInt(age -> age).min());
        System.out.println(Arrays.stream(ages).mapToInt(age -> age).max());

        System.out.println(Arrays.stream(ages).allMatch(age -> age > 20));
        System.out.println(Arrays.stream(ages).anyMatch(age -> age > 20));

        System.out.println(Arrays.stream(ages).findFirst());
        System.out.println(Arrays.stream(ages).findAny());

        Arrays.stream(ages).sorted().forEach(System.out::println);
        //Arrays.stream(ages).sorted().forEach(age -> System.out.println(age));

    }
}

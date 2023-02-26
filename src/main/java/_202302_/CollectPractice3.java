package _202302_;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectPractice3 {
    /**
     * Collectors.reducing()
     *
     * Collector reducing (BinaryOperator<T> operator)
     * Collector reducing (T identity, BinaryOperator<T> operator)
     * Collector reducing(U identity, Function<T,U> mapper, BinaryOperator<U> operator)
     */
    public static void main(String[] args) {
        Integer studentScoreSum = Stream.of(arr)
                .collect(Collectors.reducing(0, Student::getScore, Integer::sum));
        //비교
        Integer studentScoreSum2 = Stream.of(arr)
                .map(Student::getScore)
                .reduce(0, Integer::sum);
        System.out.println("studentScoreSum = " + studentScoreSum);
        System.out.println("studentScoreSum2 = " + studentScoreSum2);


        /**
         * collect()사용시 유의
         *
         *  IntStream의 collect()는 매개변수 3개짜리만 정의되어있음
         *  매개변수 1개짜리 collect()를 쓰기 위해서는
         *  IntStream을 Stream<Integer>로 변환해야함 -> boxed()사용
         */
        IntStream randomNums = new Random()
                .ints(1, 46)
                .distinct()
                .limit(6);
        Integer randomNumSum = randomNums.boxed().collect(Collectors.reducing(0, (a, b) -> a + b));
        System.out.println("randomNumSum = " + randomNumSum);
        //비교
        int randomNumSum2 = new Random()
                .ints(1, 46)
                .distinct()
                .limit(6)
                .reduce(0, (a, b) -> a + b);
        System.out.println("randomNumSum2 = " + randomNumSum2);

    }

    static Student[] arr = {
            new Student("나자바", true, 1, 1, 300),
            new Student("김지미", false, 1, 1, 250),
            new Student("김자바", true, 1, 1, 200),
            new Student("이지미", false, 1, 2, 150),
            new Student("남자바", true, 1, 2, 100),
            new Student("안지미", false, 1, 2, 50),
            new Student("황지미", false, 1, 3, 100),
            new Student("강지미", false, 1, 3, 150),
            new Student("이자바", true, 1, 3, 200),
            new Student("나자바", true, 2, 1, 300),
            new Student("김지미", false, 2, 1, 250),
            new Student("김자바", true, 2, 1, 200),
            new Student("이지미", false, 2, 2, 150),
            new Student("남자바", true, 2, 2, 100),
            new Student("안지미", false, 2, 2, 50),
            new Student("황지미", false, 2, 3, 100),
            new Student("강지미", false, 2, 3, 150),
            new Student("이자바", true, 2, 3, 200)
    };
}



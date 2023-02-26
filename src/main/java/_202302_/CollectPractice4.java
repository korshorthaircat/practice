package _202302_;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectPractice4 {
    /**
     * Collectors.joining()
     */
    public static void main(String[] args) {
        String studentNameStr = Stream.of(arr)
                .map(Student::getName)
                .collect(Collectors.joining());
        System.out.println("studentNameStr = " + studentNameStr);

        String studentNameStr2 = Stream.of(arr)
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("studentNameStr2 = " + studentNameStr2);

        String studentNameStr3 = Stream.of(arr)
                .map(Student::getName)
                .collect(Collectors.joining(",", "<<", ">>"));
        System.out.println("studentNameStr3 = " + studentNameStr3);

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



package _202302_;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectPractice2 {
    /**
     * Collectors의 통계 메서드 연습
     *
     *    Collectors.counting()
     *    Collectors.summingInt()
     *    Collectors.averagingInt()
     *    Collectors.maxBy()
     *    Collectors.minBy()
     *    Collectors.summarizingInt()
     */
    public static void main(String[] args) {



        /**
         * Collectors.counting()
         */
        Long studentCount = Stream.of(arr)
                .collect(Collectors.counting());
        //비교
        Long studentCount2 = Stream.of(arr)
                .count();
        System.out.println("studentCount = " + studentCount);
        System.out.println("studentCount2 = " + studentCount2);

        /**
         * Collectors.summingInt()
         */
        Integer studentScoreSum = Stream.of(arr)
                .collect(Collectors.summingInt(Student::getScore));
        //비교
        int studentScoreSum2 = Stream.of(arr)
                .mapToInt(Student::getScore)
                .sum();
        System.out.println("studentScoreSum = " + studentScoreSum);
        System.out.println("studentScoreSum2 = " + studentScoreSum2);

        /**
         * Collectors.averagingInt()
         */
        Double StudentScoreAverage = Stream.of(arr)
                .collect(Collectors.averagingInt(Student::getScore));
        //비교
        OptionalDouble studentScoreAverage2 = Stream.of(arr)
                .mapToInt(Student::getScore).average();
        System.out.println("StudentScoreAverage = " + StudentScoreAverage);
        System.out.println("studentScoreAverage2 = " + studentScoreAverage2);

        /**
         * Collectors.maxBy()
         */
        Optional<Student> topStudent = Stream.of(arr)
                .collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore)));
        //비교
        Optional<Student> topStudent2 = Stream.of(arr)
                .max(Comparator.comparingInt(Student::getScore));
        System.out.println("topStudent = " + topStudent);
        System.out.println("topStudent2 = " + topStudent2);

        /**
         * Collectors.minBy()
         */
        Optional<Student> bottomStudent = Stream.of(arr)
                .collect(Collectors.minBy(Comparator.comparingInt(Student::getScore)));
        //비교
        Optional<Student> bottomStudent2 = Stream.of(arr)
                .min(Comparator.comparing(Student::getScore));
        System.out.println("bottomStudent = " + bottomStudent);
        System.out.println("bottomStudent2 = " + bottomStudent2);

        /**
         * Collectors.summarizingInt()
         */
        IntSummaryStatistics studentScoreSummaryStatistics = Stream.of(arr)
                .collect(Collectors.summarizingInt(Student::getScore));
        System.out.println("studentScoreSummaryStatistics = " + studentScoreSummaryStatistics);
        //비교
        IntSummaryStatistics studentScoreSummaryStatistics2 = Stream.of(arr)
                .mapToInt(Student::getScore).summaryStatistics();
        System.out.println("studentScoreSummaryStatistics2 = " + studentScoreSummaryStatistics2);


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



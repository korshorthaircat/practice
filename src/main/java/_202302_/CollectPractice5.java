package _202302_;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectPractice5 {
    /**
     * 연습
     * Collectors.groupingBy()
     * Collectors.partitioningBy()
     */
    public static void main(String[] args) {

        /**
         * 분할 - 스트림의 요소를 지정된 기준(Predicate)에 따라 분할(지정된 조건에 일치하는 그룹과 일치하지 않는 그룹으로...)
         * Collectors.partitioningBy()
         *
         * Collector partitioningBy(Predicate predicate)
         * Collector partitioningBy(Predicate predicate, Collector downstream)
         */
        Map<Boolean, List<Student>> studentBySex = Stream.of(arr)
                .collect(Collectors.partitioningBy(Student::isMale));
        List<Student> maleStudentList = studentBySex.get(true);
        List<Student> femaleStudentList = studentBySex.get(false);
//        System.out.println(maleStudentList);
//        System.out.println(femaleStudentList);

        Map<Boolean, Long> studentCountBySex = Stream.of(arr)
                .collect(Collectors.partitioningBy(Student::isMale, Collectors.counting()));
        Long maleStudentCount = studentCountBySex.get(true);
        System.out.println("maleStudentCount = " + maleStudentCount);

        Map<Boolean, Integer> studentScoreSumBySex = Stream.of(arr)
                .collect(Collectors.partitioningBy(Student::isMale, Collectors.summingInt(Student::getScore)));
        System.out.println("maleStudentScoreSum = " + studentScoreSumBySex.get(true));
        System.out.println("femaleStudentScoreSum = " + studentScoreSumBySex.get(false));


        /**
         * 그룹화 - 스트림의 요소를 특정 기준(Function)으로 그룹화
         * Collectors.groupingBy()
         *
         * Collector groupingBy(Function classifier)
         * Collector groupingBy(Function classifier, Collector downstream)
         * Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
         */



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



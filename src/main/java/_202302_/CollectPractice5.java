package _202302_;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectPractice5 {
    /**
     * 연습
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


        Map<Boolean, Optional<Student>> topScoreStudentBySex = Stream.of(arr)
                .collect(Collectors.partitioningBy(Student::isMale, Collectors.maxBy(Comparator.comparing(Student::getScore))));
        Optional<Student> topScoreMaleStudent = topScoreStudentBySex.get(true);
        Optional<Student> topScoreFemaleStudent = topScoreStudentBySex.get(false);
        System.out.println("topScoreFemaleStudent = " + topScoreFemaleStudent);
        System.out.println("topScoreMaleStudent = " + topScoreMaleStudent);
        //결과
//        femaleStudentTopScore = Optional[Student{name='김지미', isMale=false, hak=1, ban=1, score=250}]
//        maleStudentTopScore = Optional[Student{name='나자바', isMale=true, hak=1, ban=1, score=300}]

        Map<Boolean, Student> topScoreStudentBySex2 = Stream.of(arr)
                .collect(Collectors.partitioningBy(
                                Student::isMale,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Student::getScore)), Optional::get
                                )
                        )
                );
        Student topScoreMaleStudent2 = topScoreStudentBySex2.get(true);
        Student topScoreFemaleStudent2 = topScoreStudentBySex2.get(false);
        System.out.println("topScoreFemaleStudent2 = " + topScoreFemaleStudent2);
        System.out.println("topScoreMaleStudent2 = " + topScoreMaleStudent2);
        //결과
//        topScoreFemaleStudent2 = Student{name='김지미', isMale=false, hak=1, ban=1, score=250}
//        topScoreMaleStudent2 = Student{name='나자바', isMale=true, hak=1, ban=1, score=300}

        //이중분할
        Map<Boolean, Map<Boolean, List<Student>>> failedStudent = Stream.of(arr)
                .collect(
                        Collectors.partitioningBy(Student::isMale,
                                Collectors.partitioningBy(student -> student.getScore() < 150)
                        )
                );
        Map<Boolean, List<Student>> failedStudentBySex = failedStudent.get(true);
        List<Student> failedMaleStudent = failedStudentBySex.get(true);
        List<Student> failedFemaleStudent = failedStudentBySex.get(false);
        System.out.println("failedFemaleStudent = " + failedFemaleStudent);
        System.out.println("failedMaleStudent = " + failedMaleStudent);
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



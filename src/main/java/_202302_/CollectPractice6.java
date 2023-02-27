package _202302_;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectPractice6 {
    /**
     * 연습
     * Collectors.groupingBy()
     */
    public static void main(String[] args) {

        /**
         * 그룹화 - 스트림의 요소를 특정 기준(Function)으로 그룹화
         * Collectors.groupingBy()
         *
         * Collector groupingBy(Function classifier)
         * Collector groupingBy(Function classifier, Collector downstream)
         * Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)
         */

        Map<Integer, List<Student>> studentListByHak = Stream.of(arr)
                .collect(Collectors.groupingBy(Student::getHak));
//        Map<Integer, List<Student>> studentListByHak2 = Stream.of(arr)
//                .collect(Collectors.groupingBy(Student::getHak, Collectors.toList())); //위 코드와 동일
        List<Student> hak1StudentList = studentListByHak.get(1);
        List<Student> hak2StudentList = studentListByHak.get(2);
        List<Student> hak3StudentList = studentListByHak.get(3);
        System.out.println("hak1StudentList = " + hak1StudentList);

        Map<Integer, Set<Student>> studentSetByHak = Stream.of(arr)
                .collect(Collectors.groupingBy(Student::getHak, Collectors.toSet()));
        Set<Student> hak1StudentSet = studentSetByHak.get(1);
        System.out.println("hak1StudentSet = " + hak1StudentSet);

        Map<Integer, HashSet<Student>> studentHashSetByHak = Stream.of(arr)
                .collect(Collectors.groupingBy(Student::getHak, Collectors.toCollection(HashSet::new)));
        HashSet<Student> hak1StudentHashSet = studentHashSetByHak.get(1);
        System.out.println("hak1StudentHashSet = " + hak1StudentHashSet);

        Map<Student.Level, Long> studentCountByLevel = Stream.of(arr)
                .collect(
                        Collectors.groupingBy(
                                student -> {
                                    if (student.getScore() >= 200)
                                        return Student.Level.HIGH;
                                    else if (student.getScore() >= 100)
                                        return Student.Level.MID;
                                    else
                                        return Student.Level.LOW;
                                }, Collectors.counting()
                        )
                );
        System.out.println("studentCountByLevel = " + studentCountByLevel);
        Long highLevelStudentCount = studentCountByLevel.get(Student.Level.HIGH);
        Long midLevelStudentCount = studentCountByLevel.get(Student.Level.MID);
        Long lowLevelStudentCount = studentCountByLevel.get(Student.Level.LOW);
        System.out.println("highLevelStudentCount = " + highLevelStudentCount);
        System.out.println("midLevelStudentCount = " + midLevelStudentCount);
        System.out.println("lowLevelStudentCount = " + lowLevelStudentCount);

        //다수준 그룹화 - groupingBy()여러번 사용하기
        Map<Integer, Map<Integer, List<Student>>> studentByHakByBan = Stream.of(arr)
                .collect(
                        Collectors.groupingBy(
                                Student::getHak,
                                Collectors.groupingBy(
                                        Student::getBan
                                )
                        )
                );
        System.out.println("studentByHakByBan = " + studentByHakByBan);
        List<Student> studentList1Hak1Ban = studentByHakByBan.get(1).get(1);
        List<Student> studentList2Hak1Ban = studentByHakByBan.get(2).get(1);
        System.out.println("studentList2Hak1Ban = " + studentList2Hak1Ban);
        System.out.println("studentList1Hak1Ban = " + studentList1Hak1Ban);

        Map<Integer, Map<Integer, Student>> topStudentByHakByBan = Stream.of(arr)
                .collect(
                        Collectors.groupingBy(
                                Student::getHak,
                                Collectors.groupingBy(
                                        Student::getBan,
                                        Collectors.collectingAndThen(
                                                Collectors.maxBy(
                                                        Comparator.comparingInt(Student::getScore)
                                                        ),
                                                Optional::get
                                        )
                                )
                        )
                );
        System.out.println("topStudentByHakByBan = " + topStudentByHakByBan);
        Student topStudent1Hak1Ban = topStudentByHakByBan.get(1).get(1);
        System.out.println("topStudent1Hak1Ban = " + topStudent1Hak1Ban);

        Map<Integer, Map<Integer, Set<Student.Level>>> studentLevelByHakByBan = Stream.of(arr)
                .collect(
                        Collectors.groupingBy(
                                Student::getHak,
                                Collectors.groupingBy(
                                        Student::getBan,
                                        Collectors.mapping(
                                                student -> {
                                                    if (student.getScore() >= 200)
                                                        return Student.Level.HIGH;
                                                    else if (student.getScore() >= 100)
                                                        return Student.Level.MID;
                                                    else
                                                        return Student.Level.LOW;
                                                },
                                                Collectors.toSet()
                                        )
                                )
                        )
                );
        System.out.println("studentLevelByHakByBan = " + studentLevelByHakByBan);


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



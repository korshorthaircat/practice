package _202302_;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectPractice {
    /**
     * 스트림을 배열과 컬렉션으로 변환하는 연습
     */
    public static void main(String[] args) {
//        Stream.of(arr)
//                .forEach(student -> System.out.println(student.toString()));

        /**
         * collect() - 스트림의 요소를 수집하는 최종 연산. 어떻게 수집되어야 할지에 정의가 필요하므로, 매개변수로 컬렉터를 필요로 함.
         * Collector - 인터페이스, 컬렉터는 이 인터페이스를 구현해야 한다.
         * Collectors - 클래스, static메서드로 미리 작성됝 컬렉터를 제공한다.
         */
        List<String> studentNameList = Stream.of(arr)
                .map(Student::getName)
                .collect(Collectors.toList());
//        System.out.println(studentNameList);

        ArrayList<String> studentNameArrayList = Stream.of(arr)
                .map(Student::getName)
                .collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(studentNameArrayList);

        ArrayList<Student> studentList = Stream.of(arr)
                .collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(studentList);

        Set<String> studentNameSet = Stream.of(arr)
                .map(Student::getName)
                .collect(Collectors.toSet());
//        System.out.println(studentNameSet);

        HashSet<String> studentNameHashSet = Stream.of(arr)
                .map(Student::getName)
                .collect(Collectors.toCollection(HashSet::new));
//        System.out.println(studentNameHashSet);

        Map<String, Student> studentMap = Stream.of(arr)
                .collect(Collectors.toMap(student -> student.getName() + student.getHak(), student -> student));//이름 중복인 경우로 인해 key를 (이름)+(학년)으로 만듦..
        Map<String, Student> studentMap2 = Stream.of(arr)
                .collect(Collectors.toMap(student -> student.getName() + student.getHak(), Function.identity())); //위 코드와 동일.
//        System.out.println(studentMap);
//        System.out.println(studentMap2);

        //스트림의 요소들을 T[] 타입으로 반환할 때 주의하기
//        Student[] studentArr = (Student[]) Stream.of(arr).toArray(); //ClassCastException
        Student[] studentArr = Stream.of(arr).toArray(Student[]::new); //toArray()의 매개변수로 해당 타입 생성자 참조를 지정해줘야 함
//        System.out.println(Arrays.toString(studentArr));

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



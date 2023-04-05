package _202304_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * List의 제네릭 타입이 특정 객체일 때 객체의 필드 기준으로 List를 정렬하는 연습
 */
public class SortingPractice {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Alice", "developer", 25));
        list.add(new Person("Bob", "student", 30));
        list.add(new Person("James", "designer", 30));
        list.add(new Person("Amy", "designer", 35));
        list.add(new Person("Charlie", "manager", 20));

//        Collections.sort(list, new Comparator<Person>() {
//            public int compare(Person p1, Person p2) {
//                return p1.getJob().compareTo(p2.getJob());
//            }
//        });

//        Collections.sort(list, new Comparator<Person>() {
//            public int compare(Person p1, Person p2) {
//                if (p1.getJob().equals(p2.getJob())) {
//                    return p1.getAge() - p2.getAge();
//                }
//                return p1.getJob().compareTo(p2.getJob());
//            }
//        });

//        Collections.sort(list, new Comparator<Person>() {
//            public int compare(Person p1, Person p2) {
//                if (p1.getJob().equals(p2.getJob())) {
//                    if (p1.getName().equals(p2.getName())) {
//                        return p1.getAge() - p2.getAge();
//                    }
//                    return p1.getName().compareTo(p2.getName());
//                }
//                return p1.getJob().compareTo(p2.getJob());
//            }
//        });

        Collections.sort(list, (p1, p2) -> {
            if (p1.getJob().equals(p2.getJob())) {
                if (p1.getName().equals(p2.getName())) {
                    return p1.getAge() - p2.getAge();
                }
                return p1.getName().compareTo(p2.getName());
            }
            return p1.getJob().compareTo(p2.getJob());
        });

        System.out.println(list);

    }
}

class Person {
    private String name;
    private String job;
    private int age;

    public Person(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}

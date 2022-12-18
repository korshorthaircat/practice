package _202212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream001 {
    public static void main(String[] args) {

        Integer[] ages = {29, 23, 45, 12, 10, 18, 19, 56, 23, 56, 34, 23, 56, 23, 45, 67, 78};

        //for each 구문의 사용
        for(Integer age : ages) {
            if(age < 20) {
                System.out.format("%d세는 입장할 수 없습니다. %n", age);
            }
        }
        System.out.println();

        //stream의 사용
        Arrays.stream(ages) //스트림의 생성. 기존 배열을 이용해 스트림을 얻으려면 Arrays클래스의 stream() 스테이틱 메서드 사용하면 됨
                .filter(age -> age < 20) //마치 SQL 구문의 where절과 유사함. 함수형 인터페이스 중 true/false를 반환하는 Predicate 함수형 인터페이스를 filter 메서드의 인자로 제공해야 한다.
                .forEach(age -> System.out.format("%d세는 입장할 수 없습니다. %n", age)); //forEach 구문은 전달된 인자를 소비하는 함수형 인ㄴ터페이스, 즉 Consumer를 요구함
    }
}

package _202212;

public class Lambda004 {
    @FunctionalInterface //이 어노테이션을 붙일 경우 컴파일러가 함수형 인터페이스의 조건에 맞는지 검사해준다.(추상메서드가 단 하나)
    interface MyFunctionalInterface{
        public abstract int runSomething(int count); //함수형 인터페이스는 하나의 추상메서드만 가짐.
    }

    public static void main (String[] args) {
        MyFunctionalInterface mf1 = (int a) -> {return a * a;}; //이것을
        MyFunctionalInterface mf2 = a -> a * a; //아래와 같이 줄여 쓰는 것이 가능하다.
        //a가 int일 수밖에 없음을 함수형인터페이스의 RunSomething 메서드에서 정의했으므로 타입을 생략할 수 있다.(타입 추정 기능)
        //또한 runSomething 메서드에서 int가 리턴된다는 것을 정의했으므로 return을 생략할 수 있다.
        //인자가 하나이고 자료형을 표기하지 않은 경후 소괄호 생략이 가능하다.
        //코드블록에 들어갈 코드가 한 줄인 경우 중괄호 생략이 가능하다.

        System.out.println(mf2.runSomething(5));

    }


}

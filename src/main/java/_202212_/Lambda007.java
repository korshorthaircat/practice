package _202212_;

public class Lambda007 {

    public static Lambda004.MyFunctionalInterface toDo() { //메서드 반환값으로 람다식(함수형 인터페이스)을 사용
        return num -> num * num;
    }

    public static void main(String[] args) {
        Lambda004.MyFunctionalInterface mf = toDo();

        int result = mf.runSomething(3);
        System.out.println(result);
    }
}

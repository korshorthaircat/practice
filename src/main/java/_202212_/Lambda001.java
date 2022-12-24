package _202212_;

class MyTest implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable 인터페이스의 구현체!!!");
    }
}

public class Lambda001 {
    public static void main(String[] args) {
        //람다 도입 이전에는 별도의 클래스, 객체, 그리고 메서드를 생성해 사용했다.
        MyTest myTest = new MyTest();

//        Runnable r = myTest;
        myTest.run();
    }
}

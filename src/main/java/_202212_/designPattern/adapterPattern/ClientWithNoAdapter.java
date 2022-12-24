package _202212_.designPattern.adapterPattern;

public class ClientWithNoAdapter {
    public static void main(String[] args) {

        ServiceA serviceA = new ServiceA();
        ServiceB serviceB = new ServiceB();

        serviceA.runServiceA();
        serviceB.runServiceB();

        //참조변수를 통해 호출하는 메서드가 비슷한 일을 하지만, 메서드명이 다르다.
        //어댑터패턴 적용 전에는 메서드명이 통일되지 않음

    }
}

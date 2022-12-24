package _202212_.designPattern.adapterPattern;

public class AdapterServiceB {
    //어댑터패턴은 객체를 속성으로 만들어 참조하는 디자인패턴이다.
    //호출당하는 쪽의 메서드를 호출하는 쪽의 코드에 대응하드록 중간에 변환기(Adapter)를 통해 호출하는 패턴
    ServiceB serviceB = new ServiceB();

    void runService() {
        serviceB.runServiceB();
    }
}

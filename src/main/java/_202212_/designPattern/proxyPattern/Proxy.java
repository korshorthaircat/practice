package _202212_.designPattern.proxyPattern;

public class Proxy implements IService{
    IService iService;

    @Override
    public String runSomething() {
        System.out.println("프록시패턴은 호출에 대한 흐름 제어가 주목적, 반환결과를 그대로 전달한다");

        iService = new Service();
        return iService.runSomething();
    }
}

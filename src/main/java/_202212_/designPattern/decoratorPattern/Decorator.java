package _202212_.designPattern.decoratorPattern;

public class Decorator implements IService{
    IService iService;

    @Override
    public String runSomething() {
        System.out.println("데코레이터패턴은 호출에 대한 장식이 주목적, 클라이언트에게 반환 결과에 장식을 더해 전달한다");

        iService = new Service();
        return "정말" + iService.runSomething();
    }
}

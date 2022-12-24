package _202212_.designPattern.templateCallbackPattern;

public class ClientRefactoring {
    public static void main(String[] args) {

        SoldierRefactoring rambo = new SoldierRefactoring();

        //중복되는 부분을 컨텍스트로 이관함
        //스프링은 이런 식으로 리팩터링된 템플릿 콜백 패턴을 DI에 적극 활용함
        rambo.runContext("총! 총총총! 총!");

        System.out.println();

        rambo.runContext("활! 활활활! 활");

        System.out.println();

        rambo.runContext("도끼! 돋도도독 도끼!");

    }
}

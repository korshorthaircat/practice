package _202212_.designPattern.strategyPattern;

public class Client {//전략을 생성해 컨텍스트에게 주입 (=:= 무기를 조달해 군인에게 지급)
    public static void main (String[] args) {
        Strategy strategy = null;
        Soldier rambo = new Soldier();

        //총을 람보에게 전달해 전투를 수행하게 함
        strategy = new StrategyGun();
        rambo.runContext(strategy);

        System.out.println();

        //검을 람보에게 전달해 전투를 수행하게 함
        strategy = new StrategySword();
        rambo.runContext(strategy);

        System.out.println();

        //활을 람보에게 전달해 전투를 수행하게 함
        strategy = new StrategyBow();
        rambo.runContext(strategy);
    }
}

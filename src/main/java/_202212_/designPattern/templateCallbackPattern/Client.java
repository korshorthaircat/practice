package _202212_.designPattern.templateCallbackPattern;

public class Client {
    public static void main(String[] args) {

        Soldier rambo = new Soldier();

        rambo.runContext(new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println("총! 총총총! 총총!");
            }
        });

        System.out.println();

        rambo.runContext(new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println("칼! 칼카카칼! 칼칼!");
            }
        });

        System.out.println();

        rambo.runContext(new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println("도끼! 도끼도끼도끼!!!");
            }
        });
    }
}

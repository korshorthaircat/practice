package _202212_;

public class Lambda005 {

    public static void doIt(Lambda004.MyFunctionalInterface mf) {
        int i = mf.runSomething(8);
        System.out.println(i);
    }

    public static void main(String[] args) {

        Lambda004.MyFunctionalInterface mf = a -> a * a; //람다식을 변수에 할당

        doIt(mf);
    }


}

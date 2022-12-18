package _202212;

public class Lambda006 {

    public static void doIt(Lambda004.MyFunctionalInterface mf) {
        int i = mf.runSomething(10);
        System.out.println(i);
    }

    public static void main(String[] args) {

        //Lambda004.MyFunctionalInterface mf = a -> a * a; //람다식을 변수에 할당

        doIt(a -> a * a); //람다식을 단 한번만 사용할거라면, 굳이 변수에 할당할 필요도 없다.
    }


}

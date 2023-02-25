package _202302_;

public class MyFunctionalInterfaceTest {
    public static void main(String[] args) {
        
        //1. 익명객체 사용
//        MyFunctionalInterface1 myFunctionalInterface1 = new MyFunctionalInterface1() {
//            @Override
//            public void myMethod() {
//                System.out.println("MyFunctionalInterfaceTest.myMethod");
//            }
//        };
//        myFunctionalInterface1.myMethod();
        MyFunctionalInterface1 myFunctionalInterface1 = () -> System.out.println("MyFunctionalInterfaceTest.myMethod");
        myFunctionalInterface1.myMethod();


//        MyFunctionalInterface2 myFunctionalInterface2 = new MyFunctionalInterface2() {
//            @Override
//            public void myMethod(String name, String age) {
//                System.out.println(name + " is " + age + " years old.");
//            }
//        };
//        myFunctionalInterface2.myMethod("gogo", "7");
        MyFunctionalInterface2 myFunctionalInterface2 = (name, age) -> System.out.println(name + " is " + age + " years old.");
        myFunctionalInterface2.myMethod("gogo", "7");

//        MyFunctionalInterface3 myFunctionalInterface3 = new MyFunctionalInterface3() {
//            @Override
//            public int myMethod(int num1, int num2) {
//                return num1 + num2;
//            }
//        };
//        System.out.println("sum = " + myFunctionalInterface3.myMethod(4, 8));
        MyFunctionalInterface3 myFunctionalInterface3 = (num1, num2) -> num1 + num2;
        System.out.println("sum = " + myFunctionalInterface3.myMethod(4, 8));

    }

}

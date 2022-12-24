package _202212_;

import java.util.function.Supplier;

public class MethodReference002 {

    public static void main(String[] args) {
        MethodReference002 mf= new MethodReference002();
//        MethodReference002 ccc = MethodReference002::new;
        //에러. MethodReference002 is not a functional interface
        //생성자 레퍼런스로 생성한 것은 클래스의 객체가 아니라 함수형인터페이스의 구현객체이기 때문!

        Supplier<MethodReference002> factory = MethodReference002::new;

        MethodReference002 aaa = factory.get();
        MethodReference002 bbb = factory.get();

        System.out.println(aaa.hashCode());
        System.out.println(bbb.hashCode());
    }
}

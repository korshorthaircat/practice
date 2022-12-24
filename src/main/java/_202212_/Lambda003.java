package _202212_;

public class Lambda003 {

    public static void main(String[] args) {
        //자바8 람다 도입 이후익명객체 없이 바로 코드블록 사용 가능하다.
        Runnable r = () -> { //Runnable 인터페이스가 가진 추상메서드가 run() 하나뿐이므로, public void run()이 단순하게 ()로 변경될 수 있다.
            System.out.println("람다!");
        }; //로직이 한 줄로 표현되는 경우 블록기호 {}마저 생략할 수 있다.

        r.run();
    }
}

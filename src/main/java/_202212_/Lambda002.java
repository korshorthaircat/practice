package _202212_;

public class Lambda002 {
    public static void main(String[] args) {
        //별도의 클래스 정의 없이 코드블록인 메서드를 사용하고자 할 때, 익명객체를 사용할 수 있다.(자바8 람다 도입 이전 최선의 방식...)
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 객체 사용!");
            }
        };

        r.run();
    }
}

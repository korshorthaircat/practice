package _202212_.designPattern.singletonPattern;

public class Singleton {
    static Singleton singletonObject; //단일 객체를 저장하기 위한 정적참조변수

    private Singleton() {}; //new를 통해 객체를 생성할 수 없도록 생성자에 private 지정

    //단일객체를 반환하기 위한 정적 메서드
    public static Singleton getInstance() {
        if(singletonObject == null) { //정적참조변수에 객체가 할당돼있지 않은 경우에만 new를 통해 객첼르 만들고 정적참조변수에 객체를 할당한다.
            singletonObject = new Singleton();
        }
        return singletonObject; //정적참조변수에 할당되어 있는 유일한 객체의 참조를 반환한다.
    }
}

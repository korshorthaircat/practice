package _202212_.designPattern.singletonPattern;

public class Client {
    public static void main(String[] args) {
        //Singleton s = new Singleton(); //에러! Singleton()' has private access in '_202212_.designPattern.singletonPattern.Singleton
        //싱글톤 클래스에 생성자를 private로 지정하였으므로, new를 통해 객체를 생성할 수 없다.

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        //s1, s2, s3은 단일객체를 참조함
        //단일 객체인 경우 결국 공유객체로 사용되기 때문에 속성을 갖지 않게 하는 것이 정석임
        //단, 읽기전용 속성을 갖는것은 문제가 되지 않음, 단일 객체가 다른 단일 객체에 대한 참조를 속성으로 갖는것도 문제가 되지 않음(스프링 싱글턴 빈이 가져야 할 제약조건)

        s1=null;
        s2=null;
        s3=null;
    }
}

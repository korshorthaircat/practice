package _202212_.designPattern.factoryMethodPattern;

public class Driver {
    public static void main (String[] args) {

        //팩터리메서드를 보유한 객체들 생성
        Animal happy = new Dog();
        Animal mimi = new Cat();

        //팩터리메서드가 반환하는 객체들
        AnimalToy happyToy = happy.getToy();
        AnimalToy mimiToy = mimi.getToy();

        //팩터리메서드가 반환한 객체들을 사용
        happyToy.identify();
        mimiToy.identify();
    }
}

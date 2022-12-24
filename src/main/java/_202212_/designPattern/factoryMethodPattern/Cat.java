package _202212_.designPattern.factoryMethodPattern;

public class Cat extends Animal {
    //추상 팩터리 메서드 오버라이딩
    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}

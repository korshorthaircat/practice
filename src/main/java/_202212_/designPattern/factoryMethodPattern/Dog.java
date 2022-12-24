package _202212_.designPattern.factoryMethodPattern;

public class Dog extends Animal{
    @Override
    AnimalToy getToy() {
        return new DogToy();
    }
}

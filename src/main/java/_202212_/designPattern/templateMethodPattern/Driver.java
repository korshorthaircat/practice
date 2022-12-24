package _202212_.designPattern.templateMethodPattern;

public class Driver {
    public static void main(String[] args) {

        Animal happy = new Dog();
        Animal mimi = new Cat();

        happy.playWithOwner();

        System.out.println();

        mimi.playWithOwner();
    }
}

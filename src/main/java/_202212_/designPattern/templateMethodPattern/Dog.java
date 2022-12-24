package _202212_.designPattern.templateMethodPattern;

public class Dog extends Animal {
    @Override
    void play() {
        System.out.println("멍! 멍");
    }

    @Override
    void runSomething() {
        System.out.println("멍! 꼬리 살랑 살랑~");
    }
//    public void playWithOwner() {
//        System.out.println("귀염둥이 이리온~");
//        System.out.println("멍! 멍!");
//        System.out.println("꼬리 살랑 살랑~");
//        System.out.println("잘했어!");
//    }
}

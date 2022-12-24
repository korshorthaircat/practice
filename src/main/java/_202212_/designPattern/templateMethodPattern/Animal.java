package _202212_.designPattern.templateMethodPattern;

public abstract class Animal {

    //공통 로직을 수행하는 템플릿 메서드
    public void playWithOwner() {
        System.out.println("귀염둥이 이리온...");
        play();
        runSomething();
        System.out.println("잘했어!");
    }

    //하위클래스에게 오버라이딩을 강제하는 추상 메서드
    abstract void play();

    //선택적으로 오버라이딩할 수 있는 훅(Hook) 메서드, 갈고리 메서드
    void runSomething() {
        System.out.println("꼬리 살랑 살랑~");
    }
}

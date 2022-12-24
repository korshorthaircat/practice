package _202212_.designPattern.templateCallbackPattern;

public class SoldierRefactoring {

    void runContext(String weaponSound) {
        System.out.println("--전투 시작--");
        executeWeapon(weaponSound);
        System.out.println("--전투 종료--");
    }

    private Strategy executeWeapon(final String weaponSound) { //전략을 생성하는 코드가 컨텍스트 내부로 들어옴
        return new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println(weaponSound);
            }
        };
    }
}

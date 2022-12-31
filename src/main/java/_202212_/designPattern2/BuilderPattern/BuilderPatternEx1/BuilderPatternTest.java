package _202212_.designPattern2.BuilderPattern.BuilderPatternEx1;

public class BuilderPatternTest {
    public static void main (String[] args) {

        //빌더 객체 생성
        PersonInfoBuilder personInfoBuilder = new PersonInfoBuilder();

        //빌더 객체에 원하는 데이터 셋
        PersonInfo personInfo = personInfoBuilder
                .setName("김고고")
                .setAge(20)
                .setFavoriteAnimal("cat")
                .setFavoriteColor("blue")
                .setName("김양양") //같은 메서드 재호출시 나중 호출한 값이 들어감
                .setFavoriteNumber(9)
                .build();

        System.out.println(personInfo.toString());
    }
}

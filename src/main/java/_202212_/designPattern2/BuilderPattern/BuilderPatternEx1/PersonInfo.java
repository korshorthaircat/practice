package _202212_.designPattern2.BuilderPattern.BuilderPatternEx1;

public class PersonInfo {
    /**
     * 제약사항 : 이 객체는 한번 생성되면 읽기(Read)만 가능해야 합니다.
     */
    private String name;
    private Integer age;
    private String favoriteColor;
    private String favoriteAnimal;
    private Integer favoriteNumber;

    public PersonInfo(String name, Integer age, String favoriteColor, String favoriteAnimal, Integer favoriteNumber){
        this.name = name;
        this.age = age;
        this.favoriteColor = favoriteColor;
        this.favoriteAnimal = favoriteAnimal;
        this.favoriteNumber = favoriteNumber;
    }

    public String toString(){
        return String.format("name:%s, age:%d, favoriteColor:%s, favoriteAnimal:%s, favoriteNumber:%d"
                , name, age, favoriteColor, favoriteAnimal, favoriteNumber);
    }
}


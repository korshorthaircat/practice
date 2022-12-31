package _202212_.designPattern2.BuilderPattern.BuilderPatternEx4;

import lombok.Builder;

@Builder
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static void main(String[] args) {
        NutritionFacts.builder()
                .servingSize(1)
                .servings(1)
                .calories(1)
                .fat(1)
                .sodium(1)
                .carbohydrate(1)
                .build();
    }
//    기본 생성자는 만들어주지 않음
//    setter없이 필요한 매개변수 값을 set한 후에 build하여 thread-safe하게 사용할 수 있다.
}

package _202302_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class CollectionFunctionalInterfaceTest {
    public static void main(String[] args) {
        List<Integer> numberList =  new ArrayList();
        for(int i = 1; i <= 10; i++) {
            numberList.add(i);
        }

        numberList.forEach(i -> {
                System.out.print(i + ", ");
        });
        System.out.println();

        numberList.replaceAll(i -> i % 2 == 0 ? 100 : i);
        for (Integer i : numberList) {
            System.out.print(i + ", ");
        }
        System.out.println();

        numberList.removeIf(i -> i % 2 == 0 || i % 3 == 0);
        for (Integer i : numberList) {
            System.out.print(i + ", ");
        }
        System.out.println();

        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 1);
        map.put("딸기", 2);
        map.put("포도", 3);
        map.put("망고", 4);

        //V compute(K key, BiFunction<K, V, V> function)
        //지정된 키의 값에 작업 function를 수행한다.
        map.compute("망고", (key, value) -> value * 100);
        //void forEach(BiConsumer<K, V> action)
        //모든 요소에 작업 action을 수행
        map.forEach((key, value) -> System.out.printf(key + " : " + value + ", "));
        System.out.println();

        //V computeIfAbsent(K key, Function<K, V> function)
        //지정된 키가 없으면, 작업 function을 수행 후 추가한다.
        map.computeIfAbsent("바나나", value -> 10);
        map.forEach((key, value) -> System.out.printf(key + " : " + value + ", "));
        System.out.println();

        //V computeIfPresent(K key, BiFunction<K, V, V> function)
        //지정된 키가 있으면, 작업 function을 수행
        map.computeIfPresent("딸기", (key, value) -> value * value);
        map.forEach((key, value) -> System.out.printf(key + " : " + value + ", "));
        System.out.println();

        //V merge(K key, V value, BiFunction<V, V, V> function)
        //모든 요소에 병합작업 function을 수행 (key가 같을 때 맵의 값을 덮어씌움)
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("사과", 1);
        map2.put("딸기", 2);
        map2.put("포도", 3);
        map2.put("망고", 4);

        map2.forEach((key, value) -> map.merge(key, value, (v1, v2) -> v2));
        System.out.println(map);

        map2.forEach((key, value) -> map.merge(key, value, (v1, v2) -> v1 + v2));
        System.out.println(map);

        //void replaceAll(BiFunction<K, V, V> function)
        //모든 요소에 치환작업 f를 수행
        map.replaceAll((key, value) -> value + 1);
        System.out.println(map);
    }


}

package _202302_;

import _202302_.code.strategypattern.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class StrategyPatternTest {

    /**
     * 전략 패턴 사용
     * - ContextV1: 컨텍스트가 내부 필드에 전략을 갖고 있음
     */
    @Test
    void strategyPatternV1Test1() {
        Strategy strategy1 = new Logic1();
        ContextV1 context1 = new ContextV1(strategy1);
        context1.execute();

        Strategy strategy2 = new Logic2();
        ContextV1 context2 = new ContextV1(strategy2);
        context2.execute();
    }

    /**
     * 전략 패턴 사용
     * - ContextV2: 컨텍스트가 매번 실행할때마다 전략을 인자로 전달받음
     */
    @Test
    void strategyPatternV2Test1() {
        Strategy strategy1 = new Logic1();
        ContextV2 context1 = new ContextV2();
        context1.execute(strategy1);

        Strategy strategy2 = new Logic2();
        ContextV2 context2 = new ContextV2();
        context2.execute(strategy2);
    }

    /**
     * 전략 패턴 사용
     * - ContextV2: 컨텍스트가 매번 실행할때마다 전략을 인자로 전달받음
     * - 익명클래스 사용
     */
    @Test
    void strategyPatternV2Test2() {
        ContextV2 context1 = new ContextV2();
        context1.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        });

        ContextV2 context2 = new ContextV2();
        context2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2");
            }
        });
    }

    /**
     * 전략 패턴 사용
     * - ContextV2: 컨텍스트가 매번 실행할때마다 전략을 인자로 전달받음
     * - 람다 사용
     */
    @Test
    void strategyPatternV2Test3() {
        ContextV2 context1 = new ContextV2();
        context1.execute(() -> log.info("비즈니스 로직1"));

        ContextV2 context2 = new ContextV2();
        context2.execute(() -> log.info("비즈니스 로직2"));
    }


}

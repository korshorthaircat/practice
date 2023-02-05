package _202302_.code.strategypattern;

import lombok.extern.slf4j.Slf4j;

/**
 * Context가 내부의 필드로 전략을 갖고 있음.
 */
@Slf4j
public class ContextV1 {

    private final Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 시작
        strategy.call();
        //비즈니스 로직 끝

        long endTime = System.currentTimeMillis();
        log.info("경과시간={}", endTime - startTime);
    }
}

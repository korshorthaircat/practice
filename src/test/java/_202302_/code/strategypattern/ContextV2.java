package _202302_.code.strategypattern;

import lombok.extern.slf4j.Slf4j;

/**
 * Context가 매번 실행할 때마다 전략을 인자로 전달받음
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 시작
        strategy.call();
        //비즈니스 로직 끝

        long endTime = System.currentTimeMillis();
        log.info("경과시간={}", endTime - startTime);
    }
}

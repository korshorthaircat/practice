package _202302_.code.strategypattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logic1 implements Strategy {
    @Override
    public void call() {
      log.info("비즈니스 로직1 실행");
    }
}

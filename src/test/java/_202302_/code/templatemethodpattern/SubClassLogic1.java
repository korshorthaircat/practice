package _202302_.code.templatemethodpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate {
    @Override
    public void call() {
      log.info("로직1 실행");
    }
}

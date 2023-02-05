package _202302_.code.templatemethodpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate {
    @Override
    public void call() {
       log.info("로직2 실행");
    }
}

package _202302_;

import _202302_.code.templatemethodpattern.AbstractTemplate;
import _202302_.code.templatemethodpattern.SubClassLogic1;
import _202302_.code.templatemethodpattern.SubClassLogic2;
import lombok.extern.slf4j.*;
import org.testng.annotations.Test;

@Slf4j
public class TemplateMethodPatternTest {

    /**
     * 템플릿 메서드 패턴 적용
     */
    @Test
    void templateMethodPatternTest1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    /**
     * 템플릿 메서드 패턴 적용2
     *  - 익명 내부 클래스 사용
     */
    @Test
    void templateMethodPatternTest2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            public void call() {
                log.info("로직1");
            }
        };
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            public void call() {
                log.info("로직2");
            }
        };
        template2.execute();
    }
}

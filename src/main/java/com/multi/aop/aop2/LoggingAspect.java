package com.multi.aop.aop2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //what, when, where
@Component //객체를 생성하라는 어노테아션
public class LoggingAspect {
    @Before("execution(* com.multi.repository.ActionService.*(..))") //*(..) *은 모든 메서드 의미, ..은 인자 넣어도 되고 안넣어도 되거
    public void beforeMethod() {
        System.out.println("beforeMethod"); //what (공통단 코드)
    }
}

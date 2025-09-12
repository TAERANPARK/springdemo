package com.multi.aop.aop2;

import com.multi.repository.ActionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aop2Main {
    public static void main(String[] args) {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectConfig.class);
       // System.out.println(applicationContext.getBean("actionServiceImpl")); //비즈니스로직 수행을 위한 객체
        ActionService actionService = applicationContext.getBean("actionServiceImpl",ActionService.class);
        actionService.showMessage(); //비즈니스 로직 수행부분
        System.out.println(applicationContext.getBean("pop"));
    }
}

/*
 비즈니스 로직 에러시
 비즈니스로직에서 에러 났을 때 @Before는 메서드 실행 전에 실행해서 나오고
 에러가 나니까 @AfterThrowing 먼저 실행되고
 @After는 오류 여부와 상관 없이 실행되어 나온다
 */

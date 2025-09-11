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
        actionService.makeProcess();
    }
}

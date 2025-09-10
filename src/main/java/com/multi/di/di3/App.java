package com.multi.di.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext 생성자 인자로 xmlText를 인자로 넘기면
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        applicationContext.getBean("memberServiceWithSetter");
    }
}

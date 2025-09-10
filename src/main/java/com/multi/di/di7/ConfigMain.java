package com.multi.di.di7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigDemo.class);
        System.out.println(applicationContext.getBean("getStateServer"));
        System.out.println(applicationContext.getBean("msg"));
        System.out.println(applicationContext.getBean("person1"));
    }
}

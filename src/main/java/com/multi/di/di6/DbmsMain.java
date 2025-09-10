package com.multi.di.di6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbmsMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/dbms.xml");
        System.out.println(applicationContext.getBean("dbServer"));
    }
}
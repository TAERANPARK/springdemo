package com.multi.app;

import com.multi.di.di1.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/person.xml"); //라이브러리. 스프링 객체 만들어줌
        //System.out.println(applicationContext.getBean("person1"));
        applicationContext.getBean("person1",Person.class).setName("수정");
        System.out.println(applicationContext.getBean("person1",Person.class).getName()); //태란


    }
}

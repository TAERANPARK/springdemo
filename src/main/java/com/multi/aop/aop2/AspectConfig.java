package com.multi.aop.aop2;

import com.multi.di.di1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//XML을 대신 하는 클래스
@Configuration//조립기
@ComponentScan(basePackages = {"com.multi.repository","com.multi.aop.aop2"})
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean(name = "pop")
    public Person person(){
        return new Person();
    }

}

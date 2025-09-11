package com.multi.aop.aop2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//조립기
@ComponentScan(basePackages = {"com.multi.repository","com.multi.aop.aop2"})
@EnableAspectJAutoProxy
public class AspectConfig {

}

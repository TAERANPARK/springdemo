package com.multi.aop.aop1;

import com.multi.service.MyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAopMain {
    public static void main(String[] args) {
        // applicationContext는 xmlDom을 의미한다
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/spring/aop1.xml");
        System.out.println(applicationContext);

        //MyService는 핵심코드
        MyService myService = applicationContext.getBean(MyService.class);
        //핵심 코드를 콜하면 ... aop에 저장한대로 전처리, 후처리가 진행 됨
        System.out.println(myService.performAction("XML")); // AOP Before 로그 + 결과
        myService.showMessage();//비즈니스 로직 수행합니다..

    }
}

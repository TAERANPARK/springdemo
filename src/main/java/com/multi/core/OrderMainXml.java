package com.multi.core;


import com.multi.core.member.Member;
import com.multi.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderMainXml {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/app-context.xml");
        OrderService os = (OrderService) ac.getBean("orderService");

        Member member1 = new Member(1,"신짱구","VIP");
        os.createOrder(member1,50000);

        Member member2 = new Member(2,"신짱아","BASIC");
        os.createOrder(member2,20000);
    }
}

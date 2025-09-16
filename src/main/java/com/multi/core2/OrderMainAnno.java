package com.multi.core2;

import com.multi.core2.config.AppConfig;
import com.multi.core2.member.Grade;
import com.multi.core2.member.Member;
import com.multi.core2.order.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderMainAnno {
    public static void main(String[] args) {
        String active = System.getProperty("spring.profiles.active");
        try (AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext()) {
        if (active == null || active.isBlank()) active = "prod"; // prod로 바꿔도 됨
        ac.getEnvironment().setActiveProfiles(active);

        ac.register(AppConfig.class);
        ac.refresh();

            OrderService os = ac.getBean(OrderService.class);
            os.createOrder(new Member(1,"남도일", Grade.VIP),   50000);
            os.createOrder(new Member(2,"고뭉치", Grade.BASIC), 30000);
        }
    }
}

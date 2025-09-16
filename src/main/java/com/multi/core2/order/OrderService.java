package com.multi.core2.order;

import com.multi.core2.member.Member;
import com.multi.core2.discount.DiscountPolicy;
import com.multi.core2.notify.Notifier;
import com.multi.core2.time.TimeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service

public class OrderService {
    private List<DiscountPolicy> discountPolicy;
    private List<Notifier>  notifiers;
    private TimeProvider timeProvider;

    @Autowired
    public OrderService(List<DiscountPolicy> discountPolicy,
                        List<Notifier> notifiers,
                        TimeProvider timeProvider) {
        this.discountPolicy = discountPolicy;
        this.notifiers = notifiers;
        this.timeProvider = timeProvider;
    }

    @PostConstruct
    void init(){ System.out.println("[OrderService:init]"); }

    @PreDestroy
    void destroy(){ System.out.println("[OrderService:destroy]"); }

    public void createOrder(Member member, int price) {
        int fixDiscount = 0;
        int rateDiscount = 0;

        for (com.multi.core2.discount.DiscountPolicy p : discountPolicy) {
            int d = p.discount(member, price);
            if (p instanceof com.multi.core2.discount.FixDiscountPolicy) {
                fixDiscount += d;
            } else if (p instanceof com.multi.core2.discount.RateDiscountPolicy) {
                rateDiscount += d;
            }
        }

        int totalDiscount = fixDiscount + rateDiscount;
        int pay = price - totalDiscount;
        String time = timeProvider.now();

        System.out.println("주문자: " + member.getName()
                + ", 회원등급: " + member.getGrade()
                + " | 기본 할인: " + fixDiscount
                + " | 등급별 할인: " + rateDiscount
                + " | 총 할인: " + totalDiscount
                + " | 결제 금액: " + pay
                + " | 주문 시간: " + time);

        for (com.multi.core2.notify.Notifier n : notifiers) n.notify(member, "주문금액: " + pay + "원");

    }
}

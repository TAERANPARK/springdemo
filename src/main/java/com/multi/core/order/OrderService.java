package com.multi.core.order;

import com.multi.core.discount.DiscountPolicy;
import com.multi.core.member.Member;
import com.multi.core.notify.Notifier;
import com.multi.core.time.TimeProvider;

import java.util.List;

public class OrderService {
    private List<DiscountPolicy> discountPolicy;
    private List<Notifier>  notifiers;
    private TimeProvider timeProvider;

    public void setDiscountPolicy(List<DiscountPolicy> discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void setNotifiers(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void setTimeProvider(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void createOrder(Member member, int price) {
        int fixDiscount = 0;
        int rateDiscount = 0;

        for (DiscountPolicy p : discountPolicy) {
            int d = p.discount(member, price);
            if (p instanceof com.multi.core.discount.FixDiscountPolicy) {
                fixDiscount += d;
            } else if (p instanceof com.multi.core.discount.RateDiscountPolicy) {
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

        for (Notifier n : notifiers) n.notify(member, "주문금액: " + pay + "원");

    }
}

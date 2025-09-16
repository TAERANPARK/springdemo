package com.multi.core2.discount;

import com.multi.core2.discount.DiscountPolicy;
import com.multi.core2.member.Grade;
import com.multi.core2.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int rate;
    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public int discount(Member member, int price) {
        return Grade.VIP.equals(member.getGrade()) ? price * rate/100 : 0 ;
    }
}

package com.multi.core.discount;

import com.multi.core.member.Grade;
import com.multi.core.member.Member;

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

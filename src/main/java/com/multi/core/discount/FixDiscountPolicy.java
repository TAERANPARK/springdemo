package com.multi.core.discount;

import com.multi.core.member.Grade;
import com.multi.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountPrice;

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public int discount(Member member, int price) {
        return discountPrice;
    }
}

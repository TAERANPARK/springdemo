package com.multi.core2.discount;


import com.multi.core2.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}

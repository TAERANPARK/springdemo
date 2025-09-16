package com.multi.core.notify;

import com.multi.core.member.Member;

public class SmsNotifier implements Notifier {
    private String sms;

    public void setSms(String sms) {
        this.sms = sms;
    }

    @Override
    public void notify(Member member, String message) {
        System.out.println("[sms: "+sms+"] "+message);
    }
}

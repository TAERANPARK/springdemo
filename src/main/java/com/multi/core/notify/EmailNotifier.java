package com.multi.core.notify;

import com.multi.core.member.Member;

public class EmailNotifier implements Notifier {
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void notify(Member member, String message) {
        System.out.println("[Email: "+email+"] "+message);
    }
}

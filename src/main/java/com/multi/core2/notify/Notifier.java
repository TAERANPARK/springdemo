package com.multi.core2.notify;

import com.multi.core2.member.Member;

public interface Notifier {
    void notify(Member member, String message);
}

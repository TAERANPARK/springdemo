package com.multi.core.notify;

import com.multi.core.member.Member;

public interface Notifier {
    void notify(Member member, String message);
}

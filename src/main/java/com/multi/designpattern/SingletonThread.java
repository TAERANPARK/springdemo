package com.multi.designpattern;

public class SingletonThread {
    private static SingletonThread instance;

    private SingletonThread() {}

    // 메서드에 synchronized 키워드를 사용하여 스레드 안전성 보장
    // synchronized는 Locking울 가능하게 해준다..
    public static synchronized SingletonThread getInstance() {
        if (instance == null) {
            instance = new SingletonThread();
        }
        return instance;
    }

}

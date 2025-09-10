package com.multi.designpattern;


public class Singleton {
    //Singleton 키워드 들어가면 static 정적인 요소가 됨
    private static Singleton instance;

    private Singleton() {}

    // 필요할 때 인스턴스를 생성
    public static Singleton getInstance() {
        if (instance == null) {// 싱글턴 생성 스테틱이 한번만 메모리에 만들어짐
            instance = new Singleton();
        }
        return instance;
    }
}
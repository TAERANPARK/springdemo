package com.multi.di.di5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter,setter,toString
@AllArgsConstructor
@NoArgsConstructor //기본생성자
public class Book {
    private String bookName;
    private int price;
    private String author;
    private String publisher;
    // 생성자 다음으로 호출되는 함수
    public void init(){
        System.out.println("init");
    }
    // 객체가 종료되는 시점에 호출...
    public void destroy(){
        System.out.println("destroy");
    }
}

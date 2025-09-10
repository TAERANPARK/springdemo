package com.multi.di.di5;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/*
* @Resource(name="book2")
* private Book book; //선언부 가 메서드보다 우선순위가 높아서 이 상황에서는 결과적으로 book1이 출력된다
*     @Resource(name="book1")
      public void setBook(Book book) {
        this.book = book;
    }
*/

@Component(value="bookstore2")

public class BookStore2 {

    @Resource(name="book2")
    private Book book; //선언부

    public BookStore2(){
    }

    public BookStore2(Book book){
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
    @Resource(name="book1")
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "BookStore2{" +
                "book=" + book +
                '}';
    }
}

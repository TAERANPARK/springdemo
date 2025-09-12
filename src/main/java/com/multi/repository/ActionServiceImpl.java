package com.multi.repository;

import org.springframework.stereotype.Service;

@Service //service는 곧 비즈니스이다
public class ActionServiceImpl implements ActionService {
    //아래는 비즈니스 로직
    @Override
    public void showMessage() {//핵심소스
        //error
        //int rs=10/0; //Exception 발생
        System.out.println("showMessage 비즈니스 로직 수행");
    }

    @Override
    public void makeProcess() {//핵심소스
        System.out.println("makeProcess 비즈니스 로직 수행");
    }
}

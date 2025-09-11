package com.multi.aop.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {//LoggingAspect 어스펙을 받음
    //Aspect는 What + When + Where

    //When Before
    //* com.multi.service.MyService.*(..)) 핵심코드 있는 디테일한 Where = pointcut을 의미한다
    @Before("execution(* com.multi.service.MyService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // getSignature().getName() --> 비즈니스로직을 수행 했을 때 관련메소드 이름 반환
        String name = joinPoint.getSignature().getName();
        if(name.equals("performAction")){//PerformAction라는 비즈니스로직 메서드이면 ... 아래 문장 수행
            System.out.println("logBefore PerformAction");
        }else if(name.equals("showMessage")){//showMessage라는 비즈니스로직 메서드이면 ... 아래 문장 수행
            System.out.println("logBefore ShowMessage");
        }
        System.out.println("logBefore"); //What(공통부분)
    }

    //* com.multi.service.MyService.*(..)) 핵심코드(target)가 장소
    @AfterReturning("execution(* com.multi.service.MyService.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("logAfterReturning"); //What(공통부분)
    }
}

package com.multi.aop.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //what, when, where
@Component //객체를 생성하라는 어노테이션
public class LoggingAspect {
//    @Before("execution(* com.multi.repository.ActionService.*(..))") //*(..) *은 모든 메서드 의미, ..은 인자 넣어도 되고 안넣어도 되거
//    public void beforeMethod() {
//        System.out.println("beforeMethod"); //what (공통단 코드)
//    }
//
//    @AfterReturning("execution(* com.multi.repository.ActionService.*(..))")
//    public void logAfterReturning(JoinPoint joinPoint) {
//        System.out.println("logAfterReturning"); //what (공통단 코드)
//    }
//
//    @After("execution(* com.multi.repository.ActionService.*(..))") // @After = when / 오류 여부와 상관없이 실행
//    public void afterMethod() {
//        System.out.println("afterMethod"); //what (공통단 코드)
//    }
//
//    @AfterThrowing("execution(* com.multi.repository.ActionService.*(..))") // @AfterThrowing 예외 났을 때 먼저 실행
//    public void afterThrowing() {
//        System.out.println("afterThrowing"); //what (공통단 코드)
//    }

    @Around("execution(* com.multi.repository.ActionService.*(..))")
    public void aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Around Before 실행");
        try { //비즈니스 로직 수행 됐을 때
            proceedingJoinPoint.proceed();
            System.out.println("Around Process");
        }catch (Throwable e){
            System.out.println("Around Exception");
            e.printStackTrace();
        }finally { //에러가 나던 안나던 수행
            System.out.println("Around finally");
        }
        System.out.println("Around After Returning");
    }
}

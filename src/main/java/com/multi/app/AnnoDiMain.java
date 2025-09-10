package com.multi.app;

import com.multi.config.DiAnnoConfig;
import com.multi.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoDiMain {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(DiAnnoConfig.class)) {

            MyService myService = ctx.getBean(MyService.class);
            System.out.println(myService.performAction("ANNO-DI")); // [DEFAULT] Hello, ANNO-DI
        }
    }
}


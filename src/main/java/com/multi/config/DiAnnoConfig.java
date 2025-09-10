package com.multi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.multi")
// com.multi.repository.MemoryMyRepository @Repository
// com.multi.service.MyServiceImpl @Service 를 자동 탐지
public class DiAnnoConfig {
    // 추가로 @Bean 등록할 게 있으면 여기서 정의
}


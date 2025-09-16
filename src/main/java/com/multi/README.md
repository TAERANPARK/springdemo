## XML 기반 실행 (Part B)
### 🪄 실행 순서
1. OrderMainXml이 new ClassPathXmlApplicationContext("spring/app-context.xml")로 컨테이너 시작.


2. XML 파싱

- TimeProvider(생성자 인자), RateDiscountPolicy(rate=10), FixDiscountPolicy(1000),
EmailNotifier, SmsNotifier, OrderService(세터로 컬렉션/참조 주입) 모두 싱글턴 생성

3. OrderService에 세터로 주입

- discountPolicy에 두 정책 리스트, notifiers에 두 노티파이어 리스트, timeProvider 참조, mainPolicy=rateDiscountPolicy

(클래스에 @PostConstruct가 있으면) 초기화 콜백 실행

5. OrderMainXml이 OrderService.createOrder(...) 호출

- 할인 합산: 1000원 + VIP 10%
- 알림 출력



## 애너테이션 기반 실행 (Part B)

### 🪄 실행 순서

1. OrderMainAnno가 new AnnotationConfigApplicationContext(AppConfig.class)로 컨테이너 시작.

2. AppConfig 로딩
- @PropertySource로 application.properties 읽음

- PropertySourcesPlaceholderConfigurer(@Bean) 등록 → @Value 해석 준비

3. @Bean 생성
- rateDiscountPolicy(rate=10), fixDiscountPolicy(1000), timeProvider(패턴 주입),
emailNotifier(메일), smsNotifier(SMS) 모두 싱글턴으로 생성

4. @ComponentScan("com.multi.core2")가 @Service 붙은 OrderService를 빈으로 등록

5. 의존성 주입(생성자)
- OrderService(List<DiscountPolicy>, List<Notifier>, TimeProvider)에 위 빈들이 주입됨
- 리스트 주입이므로 할인정책 2개, 노티파이어 2개가 모두 들어감

6. @PostConstruct 실행 → [OrderService:init] 출력


7. OrderMainAnno가 OrderService.createOrder(...) 두 번 호출
- 할인 계산: Fix(항상 1000원) + Rate(등급 VIP면 10%) 합산
- 로그 출력(기본/등급/총 할인, 결제금액, 시간)
- emailNotifier, smsNotifier 출력
8. try-with-resources 종료 시 ac.close() → 싱글턴 @PreDestroy 호출 → [OrderService:destroy]
---
  메인 클래스: com.multi.core2.OrderMainAnno
- 프로파일 전환 (코드에서 전환)

    » local → SmsNotifier만 로딩, [sms: ...] 로그 출력
    
    » prod → EmailNotifier만 로딩, [Email: ...] 로그 출력


    // OrderMainAnno
    ac.getEnvironment().setActiveProfiles("prod"); // 또는 "local"

- 라이프사이클: 시작 시 [OrderService:init] / 종료 시 [OrderService:destroy]


    @PostConstruct
    void init(){ System.out.println("[OrderService:init]"); }
    
    @PreDestroy
    void destroy(){ System.out.println("[OrderService:destroy]"); }


### 🪄  DI설계
1. 주입 방식

- 생성자 주입 → OrderService(List<DiscountPolicy>, List<Notifier>, TimeProvider)

- 세터 주입 → setPriorityNotifier(@Qualifier("smsNotifier"))

2. 동일 타입 충돌 해결: @Primary(RateDiscountPolicy 기본), 필요 시 @Qualifier로 특정 빈 선택


3. 컬렉션 주입: List<DiscountPolicy>, List<Notifier>로 조합


4. 환경 값 주입: @Value로 discount.rate, discount.fix, notify.*, time.format 주입


5. 프로파일 분리: local=SMS, prod=Email


6. 라이프사이클/스코프: OrderService에 @PostConstruct/@PreDestroy


7. 결과 규칙 : 항상 1,000원 기본 할인 + VIP는 추가 10% (두 정책 합산)

### 🪄 회고록
처음 XML → 애너테이션 전환에서 XML 요소를 어떤 애너테이션으로 치환해야 하는지가 제일 헷갈렸다.
애너테이션을 실제 코드에 끼워넣을 때 의존성 주입과 우선순위가 겹치면 어려움이 있었다.
코드에 애너테이션을 끼워 넣고 나면 스캔 규칙과 우선순위(@Primary/@Qualifier)가 겹치면서 주입이 흔들리거나, 
@Value/프로파일 설정이 누락되어 런타임에야 오류가 드러났다. 
XML은 문서를 눈으로 따라가면 누락을 찾기 쉬웠지만, 애너테이션은 간결한 대신 많은 부분이 컨테이너 규칙 “뒤”에 숨어 있어 어려움이 있었다.


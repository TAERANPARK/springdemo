package com.multi.core2.config;

import com.multi.core2.discount.DiscountPolicy;
import com.multi.core2.discount.FixDiscountPolicy;
import com.multi.core2.discount.RateDiscountPolicy;
import com.multi.core2.notify.EmailNotifier;
import com.multi.core2.notify.Notifier;
import com.multi.core2.notify.SmsNotifier;
import com.multi.core2.time.TimeProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.multi.core2")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer pspc() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Primary
    public DiscountPolicy rateDiscountPolicy(@Value("${discount.rate:10}") int rate) {
        RateDiscountPolicy p = new RateDiscountPolicy();
        p.setRate(rate);
        return p;
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy(@Value("${discount.fix:1000}") int price) {
        FixDiscountPolicy p = new FixDiscountPolicy();
        p.setDiscountPrice(price);
        return p;
    }

    @Bean
    public TimeProvider timeProvider(@Value("${time.format:yyyy-MM-dd HH:mm:ss}") String pattern) {
        return new TimeProvider(pattern);
    }

    @Bean
    @Profile("prod")
    public Notifier emailNotifier(@Value("${notify.email}") String email) {
        EmailNotifier n = new EmailNotifier();
        n.setEmail(email);
        return n;
    }

    @Bean
    @Scope("prototype")
    public Notifier smsNotifier(@Value("${notify.sms}") String sms) {
        SmsNotifier n = new SmsNotifier();
        n.setSms(sms);
        return n;
    }

}

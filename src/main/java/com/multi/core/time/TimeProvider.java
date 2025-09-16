package com.multi.core.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeProvider {
    private final DateTimeFormatter dateTimeFormatter;

    public TimeProvider(String pattern) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    public String now(){
        return LocalDateTime.now().format(dateTimeFormatter);
    }

}

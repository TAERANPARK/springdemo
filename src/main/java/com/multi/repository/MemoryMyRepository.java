package com.multi.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MemoryMyRepository implements MyRepository {
    @Override
    public String getMessage(String name) {
        return "Hello, " + name;
    }
}

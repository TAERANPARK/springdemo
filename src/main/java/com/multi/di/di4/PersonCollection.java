package com.multi.di.di4;


import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

//ctrl + r은 치환
//alt + enter 은 임포트

@Data
public class PersonCollection {
    private List<Person> list;
    private Set<Person> set;
    private Properties properties;
    private Map<Integer, Person> map;
    
}

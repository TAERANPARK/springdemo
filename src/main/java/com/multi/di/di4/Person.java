package com.multi.di.di4;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person() {//생성자 di도구,오버로드 가능
        super();
    }

    public Person(String name) {
        super();
        this.name = name;
    }


    public Person(String name, int age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
    }



}

package com.multi.core2.member;

public class Member {
    private long id;
    private String name;
    private String grade;

    public Member(long id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

}

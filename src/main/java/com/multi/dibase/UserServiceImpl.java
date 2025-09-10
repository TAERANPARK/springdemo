package com.multi.dibase;
// UserServiceImpl은 UserDaoJdbcImpl을 의존하는 설계도 입니다.
public class UserServiceImpl {
    // 선언부에서 UserServiceImpl치 의존하는 객체인 UserDaoJdbcImpl 객페를 di한다
    // 의존성이란 의존하는 객체의 reference(수많은 데이터와 기능)를 취득하는 것
    private UserDaoJdbcImpl jdbcImpl=new UserDaoJdbcImpl();

    public void actionSelect(){
        jdbcImpl.actionSerch(); //의존성 객체를 통해서 구현합니다..
    }
    public UserServiceImpl(UserDaoJdbcImpl jdbcImpl) {
        this.jdbcImpl = jdbcImpl;
        jdbcImpl.actionSerch();
    }

    public UserDaoJdbcImpl getJdbcImpl() {
        return jdbcImpl;
    }

    public void setJdbcImpl(UserDaoJdbcImpl jdbcImpl) {
        this.jdbcImpl = jdbcImpl;
    }

    public static void main(String[] args) {
        //의존성 주입을 생성자를 통해서..
        UserServiceImpl userService = new UserServiceImpl(new UserDaoJdbcImpl());
        //의존성 주입을 setter 메서드를 통해서 주입합니다..
        userService.setJdbcImpl(new UserDaoJdbcImpl());

    }
}

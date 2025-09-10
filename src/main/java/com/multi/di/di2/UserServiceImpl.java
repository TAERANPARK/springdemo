package com.multi.di.di2;

public class UserServiceImpl implements  UserService {
    private UserDao userDao = new UserDaoIJdbcImpl();

    @Override
    public void register() {
        userDao.insert();//의존하는 객체를 통해서 기능구현
    }

    @Override
    public void findUser() {
        userDao.select();

    }
}

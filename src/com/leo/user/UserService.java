package com.leo.user;

import java.util.UUID;

public class UserService {

    // UserDao instance
    // UserService calls UserDao methods
    private UserDao userDao = new UserDao();


    public User[] getUsers() {
        return userDao.getUsers();
    }

    public User findUserById(UUID id) {
        return userDao.findUserById(id);
    }
}

package com.leo.user;

import java.util.UUID;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public User[] getUsers() {
        return userDAO.getUsers();
    }

    public User findUserById(UUID id) {
        return userDAO.findUserById(id);
    }
}

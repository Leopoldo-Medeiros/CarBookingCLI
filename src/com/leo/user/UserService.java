package com.leo.user;

import java.util.UUID;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public User[] getUsers() {
        return userDAO.getUsers();
    }

    public User findUserById(UUID id) {
        User user = userDAO.findUserById(id);
        if (user == null) {
            throw new IllegalStateException("User not found. id: " + id);
        }
        return user;
    }
}

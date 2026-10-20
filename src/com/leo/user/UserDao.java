package com.leo.user;

import java.util.UUID;

public class UserDao {

    private static final User[] users;
    private static final int userCount = 2;

    static {
        users = new User[userCount];
        users[0] = new User(UUID.fromString("03B09364-2616-4C3C-B4F3-65D087EFE558"), "Leo");
        users[1] = new User(UUID.fromString("0DFBC93E-0402-4EBB-9A43-F314C033835E"), "Luciana");
    }

    public User[] getUsers() {
        return users;
    }

    public User findUserById(UUID id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId().equals(id)) {
                return users[i];
            }
        }
        return null;
    }
}

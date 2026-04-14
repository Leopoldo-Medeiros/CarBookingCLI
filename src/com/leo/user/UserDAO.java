package com.leo.user;

import java.util.UUID;

public class UserDAO {
    private static final User[] users = new User[2];

    static {
        users[0] = new User(UUID.fromString("8ca01d13-580a-4934-bc92-50d4567b43f9"), "James");
        users[1] = new User(UUID.fromString("6a35029a-2782-45e3-982c-47fc9ef154c1"), "Jamila");
    }

    public User[] getUsers() {
        return users;
    }

    public User findUserById(UUID id) {
        for(User user : users) {
            if(user != null && user.getId().equals(id)) {
                return user;
            }
        }
        throw new RuntimeException("User not found with ID: " + id);
    }
}

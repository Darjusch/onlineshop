package src.service;

import java.util.Arrays;

import src.enteties.User;

public class DefaultUserManagementService implements UserManagementService {
    private int lastUserIndex;
    private static final int DEFAULT_USERS_CAPACITY = 10;
    private User[] users;

    {
        users = new User[DEFAULT_USERS_CAPACITY];
    }

    public void registerUser(User user) {
        if (users.length <= lastUserIndex) {
            Arrays.copyOf(users, lastUserIndex << 1);
        }
        users[lastUserIndex++] = user;
        return;
    }

    public User[] getUsers() {
        return users;
    }
}

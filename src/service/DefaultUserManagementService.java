package src.service;

import java.util.Arrays;

import src.enteties.User;

public class DefaultUserManagementService implements UserManagementService {
    private int lastUserIndex;
    private static final int DEFAULT_USERS_CAPACITY = 10;
    private User[] users;

    static final String NO_ERROR_MESSAGE = "new user is created";
    static final String NO_EMAIL_ERROR = "You have to input email to register. Please, try one more time";
    static final String EMAIL_ALREADY_USED = "This email is already used by another user. Please, use another email";

    {
        users = new User[DEFAULT_USERS_CAPACITY];
    }

    public String registerUser(User user) {
        if (user == null) {
            return NO_EMAIL_ERROR;
        }
        if (user.getUserEmail().isEmpty()) {
            return NO_EMAIL_ERROR;
        }
        boolean emailNotUnique = Arrays.stream(users)
                .filter((currentUser) -> currentUser != null && currentUser.getUserEmail() != null)
                .anyMatch((currentUser) -> user.getUserEmail().equals(currentUser.getUserEmail()));

        if (emailNotUnique) {
            return EMAIL_ALREADY_USED;
        }
        if (users.length <= lastUserIndex) {
            Arrays.copyOf(users, lastUserIndex << 1);
        }
        users[lastUserIndex++] = user;
        return NO_ERROR_MESSAGE;
    }

    public User[] getUsers() {
        return users;
    }
}
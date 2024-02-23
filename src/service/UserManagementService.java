package src.service;

import src.enteties.User;

public interface UserManagementService {
    String registerUser(User user);

    String loginUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);

}
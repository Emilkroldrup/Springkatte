package com.example.springkatte.users.Interface;

import com.example.springkatte.users.domain.User;


import java.util.List;

public interface InterfaceUserDAO {

    // Add a user
    User addUser(User user);

    // Delete a user
    Boolean removeUser(int id);

    // Get all users
    List<User> getAllUsers();

    // Get a user by ID
    User getUserById(int id);

    // Get a user by email
    User getUserByEmail(String email);

    // Edit a user
    User editUserDetails(int id, User user);

    // Check if user exists
    boolean logincheck(User user);
}

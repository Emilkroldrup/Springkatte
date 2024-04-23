package com.example.springkatte.users.Interface;

import com.example.springkatte.users.domain.User;


import java.util.List;

public interface InterfaceUserDAO {


    User addUser(User user);

    User removeUser(int id);

    List<User> getAllUsers();

    User getUserById(int id);

    User getUserIdByEmail(String email);

    User editUserDetails(int id, User user);

    boolean logincheck(User user);
}

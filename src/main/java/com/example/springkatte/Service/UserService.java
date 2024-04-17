package com.example.springkatte.Service;

import com.example.springkatte.Domain.User;
import com.example.springkatte.Infrastructure.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    public User addUser(User user) {
        return userDAO.addUser(user);
    }
    public void removeUser(int id){
        userDAO.removeUser(id);
    }
    public User getUser(int id){
        return userDAO.getUserById(id);
    }
    public List<User> getAllUser(){
        return userDAO.getAllUsers();
    }
    public void updateUser(int id, User user){
        userDAO.EditUserDetails(id, user);
    }
}

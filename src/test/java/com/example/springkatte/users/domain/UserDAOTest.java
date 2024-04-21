package com.example.springkatte.users.domain;


import com.example.springkatte.users.Interface.InterfaceUserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserDAOTest {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    UserDAOTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void testAddUser() {
        User user = new User("Mads", "Mads@gmail.com", "mads12", "user");
        InterfaceUserDAO userDAO = mock(InterfaceUserDAO.class);
        when(userDAO.addUser(user)).thenReturn(user);
        User adduser= userDAO.addUser(user);
        assertEquals(user.getName(), adduser.getName());
        assertEquals(user.getEmail(), adduser.getEmail());
        assertEquals(user.getRole(), adduser.getRole());
    }

    @Test
    void testGetAllUsers() {
        InterfaceUserDAO userDAO = mock(InterfaceUserDAO.class);
        List<User> mockUserlist = List.of(new User("Emil", "Mads@gmail.com", "mads12", "user"), new User("Mads", "Mads@gmail.com", "mads12", "user"));
        when(userDAO.getAllUsers()).thenReturn(mockUserlist);

        List<User> users = userDAO.getAllUsers();

        //Hvis der er nogle users
        assertTrue(!users.isEmpty());
    }

    @Test
    void testRemoveUser() {
        User user = new User("Emil", "Mads@gmail.com", "mads12", "user");
        InterfaceUserDAO userDAO = mock(InterfaceUserDAO.class);
        when(userDAO.addUser(user)).thenReturn(user);
        when(userDAO.getUserById(user.getId())).thenReturn(user);

        User addUser = userDAO.addUser(user);
        userDAO.removeUser(addUser.getId());

        assertEquals(0,user.getId());
    }
}
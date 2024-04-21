package com.example.springkatte.users.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDAOTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;





    @Test
    void testAddUser() {
        User user = new User("Mads", "Mads@gmail.com", "mads12", "user");
        UserDAO userdao = new UserDAO(jdbcTemplate);
        User adduser= userdao.addUser(user);
        assertEquals(user.getName(), adduser.getName());
        assertEquals(user.getEmail(), adduser.getEmail());
        assertEquals(user.getRole(), adduser.getRole());
    }

    @Test
    void testGetAllUsers() {
        UserDAO userdao = new UserDAO(jdbcTemplate);
        List<User> users = userdao.getAllUsers();

        //Hvis der er nogle users
        assertTrue(!users.isEmpty());
    }

    @Test
    void testRemoveUser() {
        User user = new User("Emil", "Mads@gmail.com", "mads12", "user");
        UserDAO userdao = new UserDAO(jdbcTemplate);
        User addUser = userdao.addUser(user);
        userdao.removeUser(addUser.getId());
        assertNull(userdao.getUserById(addUser.getId()));
    }
}
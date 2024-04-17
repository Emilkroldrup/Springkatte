package com.example.springkatte.Infrastructure.DAO;


import com.example.springkatte.Domain.User;
import com.example.springkatte.Infrastructure.DatabaseConnection;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service

public class UserDAO {
public static int id = -1;
    public User addUser(User user){
        String sql = "INSERT INTO user (name,email,password,role) VALUES (?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3,user.getPassword());
            if ("1".equals(user.getRole())) {
                pstmt.setString(4, "Member");
            } else if ("2".equals(user.getRole())) {
                pstmt.setString(4, "Admin");
            } else {
                pstmt.setString(4, "Member");
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return  user;
    }

    public User removeUser(int id){
        User user = new User();
        String sql = "Delete FROM user WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
       PreparedStatement pstmt = conn.prepareStatement(sql) ) {
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  user;
    }

    public List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM user"; 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                allUsers.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("role")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public User getUserById(int id) {
        List<User> allUsers = getAllUsers();
        for (User user : allUsers) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User EditUserDetails(int id, User user) {
        String sql = "UPDATE user SET name=COALESCE(?, name), email=COALESCE(?, email), password=COALESCE(?, password), role=COALESCE(?, role) WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());

            if ("1".equals(user.getRole())) {
                pstmt.setString(4, "Member");
            } else if ("2".equals(user.getRole())) {
                pstmt.setString(4, "Admin");
            } else {
                pstmt.setString(4, "Member");
            }

            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


        public boolean logincheck(User user){
        List<User> allusers = new UserDAO().getAllUsers();
        boolean logincorrect = false;
        for(User u: allusers ){
            if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())){
             id = u.getId();
             logincorrect = true;
             break;
            }
        }
        if(!logincorrect){
            System.out.println("Details do not match pls try again");
        }

        return logincorrect;
    }
}

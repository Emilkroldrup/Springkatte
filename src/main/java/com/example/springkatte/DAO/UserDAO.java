package com.example.springkatte.DAO;


import com.example.springkatte.ServiceLayer.DatabaseConnection;
import com.example.springkatte.Model.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service

public class UserDAO {

    public User adduser(User user){
        String sql = "INSERT INTO user (name,email,password,role) VALUES (?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3,user.getPassword());
            if ("1".equals(user.getRole())) {
                pstmt.setString(4, "User");
            } else if ("2".equals(user.getRole())) {
                pstmt.setString(4, "Admin");
            } else {
                pstmt.setString(4, "User");
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return  user;
    }

    public User removeuser(int id){
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

    public List<User> getallusers(){
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM user"; // Corrected SQL query
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

    public User EditUserDetails(int id, User user){
        String sql = "UPDATE user SET name=?, email=?, password=?, role=? WHERE id=?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);)
        {
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3,user.getPassword());
            if ("1".equals(user.getRole())) {
                pstmt.setString(4, "User");
            } else if ("2".equals(user.getRole())) {
                pstmt.setString(4, "Admin");
            } else {
                pstmt.setString(4, "User");
            }
            pstmt.setInt(5,id);
            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}

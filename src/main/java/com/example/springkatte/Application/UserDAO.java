package com.example.springkatte.Application;


import com.example.springkatte.Domain.User;
import com.example.springkatte.Infrastructure.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public User adduser(User user){

            String sql = "INSERT INTO user (name,email,password) VALUES (?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3,user.getPassword());
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
}

package com.example.springkatte.DAO;

import com.example.springkatte.Model.Pets;
import com.example.springkatte.ServiceLayer.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetsDAO {
    // Add a pet
    public Pets addPet(Pets pet) throws SQLException {
        String sql = "INSERT INTO pets (id,age,ownerId,name,race) VALUES (?,?,?,?,?)";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, pet.getId());
            pstmt.setInt(2, pet.getAge());
            pstmt.setInt(3, pet.getOwnerId());
            pstmt.setString(4, pet.getName());
            pstmt.setString(5, pet.getRace());
            pstmt.executeUpdate();
        }
        return pet;
    }

    // Delete a pet
    public void deletePet(int id) throws SQLException {
        String sql = "DELETE FROM pets WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    // Update a pet
    public void updatePet(Pets pet) throws SQLException {
        String sql = "UPDATE pets SET age=?,name=?,race=? WHERE id=?";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, pet.getAge());
            pstmt.setString(2, pet.getName());
            pstmt.setString(3, pet.getRace());
            pstmt.setInt(4, pet.getId());
            pstmt.executeUpdate();
        }
    }

    // Get a pet by Id
   /* public Pets getPetById(int id) throws SQLException {
        String sql = "SELECT * FROM pets WHERE id = ?";
        try(Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                Pets pet = new Pets();
                pet.setId(rs.getInt("id"));
                pet.setAge(rs.getInt("age"));
                pet.setName(rs.getString("name"));
                pet.setRace(rs.getString("race"));
                return pet;
            }
        }
    }

    */
}

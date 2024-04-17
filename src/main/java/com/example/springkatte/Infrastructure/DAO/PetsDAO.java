package com.example.springkatte.Infrastructure.DAO;

import com.example.springkatte.Domain.Pets;
import com.example.springkatte.Infrastructure.DatabaseConnection;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PetsDAO {
    // Add a pet
    public Pets addPet(Pets pet) {
        String sql = "INSERT INTO pets (id,age,ownerId,name,race) VALUES (?,?,?,?,?)";
        try(Connection con = DatabaseConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, pet.getId());
            pstmt.setInt(2, pet.getAge());
            pstmt.setInt(3, pet.getOwnerId());
            pstmt.setString(4, pet.getName());
            pstmt.setString(5, pet.getRace());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }

    // Delete a pet
    public void deletePet(int id) {
        String sql = "DELETE FROM pets WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a pet
    public Pets updatePet(Pets pet) {
        String sql = "UPDATE pets SET age=?,name=?,race=? WHERE id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, pet.getAge());
            pstmt.setString(2, pet.getName());
            pstmt.setString(3, pet.getRace());
            pstmt.setInt(4, pet.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet;
    }
    // Get a pet by Id
    public Pets getPetById(int id) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

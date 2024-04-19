package com.example.springkatte.pets.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class PetsDAO {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Add a pet
    public Pets addPet(Pets pet) {
        String sql = "INSERT INTO pets (ownerId,name,race) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, pet.getAge(), pet.getOwnerId(), pet.getName(), pet.getRace());
        return pet;
    }

    // Delete a pet
    public void deletePet(int id) {
        String sql = "DELETE FROM pets WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // Update a pet
    public Pets updatePet(Pets pet) {
        String sql = "UPDATE pets SET age = ?, ownerId = ?, name = ?, race = ? WHERE id = ?";
        jdbcTemplate.update(sql, pet.getAge(), pet.getOwnerId(), pet.getName(), pet.getRace(), pet.getId());
        return pet;
    }

    // Get a pet by Id
    public Pets getPetById(int id) {
        String sql = "SELECT * FROM pets WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Pets(
                rs.getInt("id"),
                rs.getInt("age"),
                rs.getInt("ownerId"),
                rs.getString("name"),
                rs.getString("race")
        ), id);
    }
}
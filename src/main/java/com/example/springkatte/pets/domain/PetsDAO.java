package com.example.springkatte.pets.domain;

import com.example.springkatte.pets.Interface.InterfacePetsDAO;
import com.example.springkatte.users.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Service
public class PetsDAO implements InterfacePetsDAO {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Adds a pet to the database
     *
     * @param pet
     * @return the added pet
     */
    @Override
    public Pets addPet(Pets pet) {
        String sql = "INSERT INTO pets (ownerId,name,race) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, pet.getAge(), pet.getOwnerId(), pet.getName(), pet.getRace());
        return pet;
    }

    /**
     * Deletes a pet from the database
     *
     * @param id
     */
    @Override
    public void deletePet(int id) {
        String sql = "DELETE FROM pets WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    /**
     * Updates a pet in the database
     *
     * @param pet
     * @return the updated pet
     */
    @Override
    public Pets updatePet(Pets pet) {
        String sql = "UPDATE pets SET age = ?, ownerId = ?, name = ?, race = ? WHERE id = ?";
        jdbcTemplate.update(sql, pet.getAge(), pet.getOwnerId(), pet.getName(), pet.getRace(), pet.getId());
        return pet;
    }

    /**
     * Gives a specific pet by using its id
     *
     * @param id
     * @return the pet with the given id
     */
    @Override
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

    /**
     * Gives a list of all pets in the database
     *
     * @return a list of all pets in the database
     */
    @Override
    public List<Pets> getallPets() {
        String sql = "SELECT * FROM pets";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Pets(
                rs.getInt("id"),
                rs.getInt("age"),
                rs.getInt("ownerid"),
                rs.getString("name"),
                rs.getString("race")
        ));
    }
}

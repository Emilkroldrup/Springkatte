package com.example.springkatte.pets.domain;

import com.example.springkatte.pets.Interface.InterfacePetsDAO;
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
        try{
            String sql = "INSERT INTO pets (ownerId,name,race) VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, pet.getAge(), pet.getOwnerId(), pet.getName(), pet.getRace());
            return pet;
        } catch (Exception e) {
            throw new RuntimeException("Error adding pet" + e.getMessage());
        }
    }

    /**
     * Deletes a pet from the database
     *
     * @param id
     * @return
     */
    @Override
    public Pets deletePet(int id) {
        try{
            Pets petRemoved = getPetByID(id);

            if (petRemoved != null) {
                String sql = "DELETE FROM pets WHERE id = ?";
                int rowsAffected = jdbcTemplate.update(sql, id);

                if (rowsAffected > 0) {
                    return petRemoved;
                } else {
                    throw new RuntimeException("Failed to remove pet with id: " + id);
                }
            } else {
                throw new RuntimeException("Pet with the id: " + id + " does not exist!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting pet with id: " + id + " " + e.getMessage());
        }
    }

    /**
     * Updates a pet in the database
     *
     * @param pet
     * @return the updated pet
     */
    @Override
    public Pets updatePet(Pets pet) {
        try{
            String sql = "UPDATE pets SET age = COALESCE(?, age), name = COALESCE(?, name), race = COALESCE(?, race),ownerid = COALESCE(?, ownerid) WHERE pet_id = ?";

            jdbcTemplate.update(sql, pet.getAge(), pet.getName(), pet.getRace(), pet.getOwnerId(), pet.getId());

            return pet;
        } catch (Exception e) {
            throw new RuntimeException("Error updating pet" + e.getMessage());
        }
    }



    /**
     * Gives a specific pet by using its id
     *
     * @param id
     * @return the pet with the given id
     */

    @Override
    public Pets getPetByID(int id) {
        try{
            String sql = "SELECT * FROM pets WHERE id = ? AND ownerId = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Pets(
                    rs.getInt("pet_id"),
                    rs.getInt("age"),
                    rs.getInt("ownerid"),
                    rs.getString("name"),
                    rs.getString("race")
            ), id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting pet with id: " + id + " " + e.getMessage());
        }
    }
    @Override
    public Pets getPetByIds(int id,int ownerid) {
        try{
            String sql = "SELECT * FROM pets WHERE pet_id = ? AND ownerId = ?";
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new Pets(
                    rs.getInt("pet_id"),
                    rs.getInt("age"),
                    rs.getInt("ownerid"),
                    rs.getString("name"),
                    rs.getString("race")
            ), id,ownerid);
        } catch (Exception e) {
            throw new RuntimeException("Error getting pet with id: " + id + " " + e.getMessage());
        }
    }



    /**
     * Gives a list of all pets in the database
     *
     * @return a list of all pets in the database
     */
    @Override
    public List<Pets> getallPets() {
        try{
            String sql = "SELECT * FROM pets";
            return jdbcTemplate.query(sql, (rs, rowNum) -> new Pets(
                    rs.getInt("id"),
                    rs.getInt("age"),
                    rs.getInt("ownerid"),
                    rs.getString("name"),
                    rs.getString("race")
            ));
        } catch (Exception e) {
            throw new RuntimeException("Error getting pets " + e.getMessage());
        }
    }
    @Override
    public List<Pets> getallPetsbyOwnerid(int ownerid) {
        try{
            String sql = "SELECT * FROM pets WHERE ownerid = ?";
            return jdbcTemplate.query(sql, (rs, rowNum) -> new Pets(
                    rs.getInt("pet_id"),
                    rs.getInt("age"),
                    rs.getInt("ownerid"),
                    rs.getString("name"),
                    rs.getString("race")
            ),ownerid );
        } catch (Exception e) {
            throw new RuntimeException("Error getting pets " + e.getMessage());
        }
    }
}

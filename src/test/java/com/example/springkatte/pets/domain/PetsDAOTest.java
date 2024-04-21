package com.example.springkatte.pets.domain;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetsDAOTest {

    private final JdbcTemplate jdbcTemplate;



    PetsDAOTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void testAddPet() {
        Pets pet = new Pets(2, "Mikkel", "SerbianCat");
        PetsDAO petsDAO = new PetsDAO(jdbcTemplate);
        Pets addpet = petsDAO.addPet(pet);
        assertEquals(pet.getAge(), addpet.getAge());
        assertEquals(pet.getOwnerId(), addpet.getOwnerId());
        assertEquals(pet.getName(), addpet.getName());
        assertEquals(pet.getRace(), addpet.getRace());
    }


    @Test
    void testGetAllUsers() {
        PetsDAO petsDAO = new PetsDAO(jdbcTemplate);
        List<Pets> pets = petsDAO.getallPets();

        //Hvis der er nogle pets
        assertTrue(!pets.isEmpty());
    }

    @Test
    void testDeletePet() {
        Pets pet = new Pets(2, "Oliver", "Garfield");
        PetsDAO petsDAO = new PetsDAO(jdbcTemplate);
        Pets addpet = petsDAO.addPet(pet);
        petsDAO.deletePet(addpet.getId());
        assertNull(petsDAO.getPetById(addpet.getId()));
    }



}
package com.example.springkatte.pets.domain;

import com.example.springkatte.pets.Interface.InterfacePetsDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PetsDAOTest {


    private final JdbcTemplate jdbcTemplate;


    @Autowired
    PetsDAOTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    void testAddPet() {
        Pets pet = new Pets(2, "Mikkel", "SerbianCat");
        InterfacePetsDAO petsDAO = mock(InterfacePetsDAO.class);
        when(petsDAO.addPet(pet)).thenReturn(pet);
        Pets addpet = petsDAO.addPet(pet);
        assertEquals(pet.getAge(), addpet.getAge());
        assertEquals(pet.getOwnerId(), addpet.getOwnerId());
        assertEquals(pet.getName(), addpet.getName());
        assertEquals(pet.getRace(), addpet.getRace());
    }


    @Test
    void testGetAllPets() {
        InterfacePetsDAO petsDAO = mock(InterfacePetsDAO.class);
        List<Pets> mockPetsList = List.of(new Pets(1, "Fluffy", "Persian"), new Pets(2, "Mittens", "Siamese"));
        when(petsDAO.getallPets()).thenReturn(mockPetsList);

        List<Pets> pets = petsDAO.getallPets();

        //Hvis der er nogle pets
        assertTrue(!pets.isEmpty());
    }

    @Test
    void testDeletePet() {
        Pets pet = new Pets(2, "Oliver", "Garfield");

        InterfacePetsDAO petsDAO = mock(InterfacePetsDAO.class);
        when(petsDAO.addPet(pet)).thenReturn(pet);
        when(petsDAO.getPetByID(pet.getId())).thenReturn(pet);

        Pets addpet = petsDAO.addPet(pet);
        petsDAO.deletePet(addpet.getId());

        assertEquals(0,pet.getId());
    }



}
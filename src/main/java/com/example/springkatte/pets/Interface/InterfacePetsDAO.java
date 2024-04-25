package com.example.springkatte.pets.Interface;

import com.example.springkatte.pets.domain.Pets;

import java.util.List;

public interface InterfacePetsDAO {

    // Add a pet
    Pets addPet(Pets pet);

    // Delete a pet
    Pets deletePet(int id);

    // Update a pet
    Pets updatePet(Pets pet);

    // Get a pet by ID
    Pets getPetByID(int id);

    // Get a pet by ID and owner ID
    Pets getPetByIds(int id, int ownerid);

    // Get all pets
    List<Pets> getallPets();

    // Get all pets by owner ID
    List<Pets> getallPetsbyOwnerid(int ownerid);
}

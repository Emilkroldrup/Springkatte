package com.example.springkatte.pets.Interface;

import com.example.springkatte.pets.domain.Pets;

public interface InterfacePetsDAO {

    // Add a pet
    Pets addPet(Pets pet);

    // Delete a pet
    void deletePet(int id);

    // Update a pet
    Pets updatePet(Pets pet);

    // Get a pet by Id
    Pets getPetById(int id);
}

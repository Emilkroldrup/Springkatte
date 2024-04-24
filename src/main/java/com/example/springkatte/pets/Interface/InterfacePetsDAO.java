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


    Pets getPetByID(int id);

    Pets getPetByIds(int id, int ownerid);

    List<Pets> getallPets();


    List<Pets> getallPetsbyOwnerid(int ownerid);
}

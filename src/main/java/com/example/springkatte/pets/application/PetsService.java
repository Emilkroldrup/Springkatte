package com.example.springkatte.pets.application;

import com.example.springkatte.pets.domain.Pets;
import com.example.springkatte.pets.domain.PetsDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {

    @Autowired
    private PetsDAO petsDAO;

    public Pets addPet(Pets pet) {
        return petsDAO.addPet(pet);
    }

    public Pets updatePet(Pets pet) {
        return petsDAO.updatePet(pet);
    }

    public void deletePet(int id) {
        petsDAO.deletePet(id);
    }

    public Pets getPetById(int id) {
        return petsDAO.getPetById(id);
    }

    public List<Pets> getAllPets() {
        return petsDAO.getallPets();
    }

    public List<Pets> getallPetsbyOwnerid(int ownerId) {
        return petsDAO.getallPetsbyOwnerid(ownerId);
    }
}
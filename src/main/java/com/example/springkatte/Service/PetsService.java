package com.example.springkatte.Service;

import com.example.springkatte.Domain.Pets;
import com.example.springkatte.Infrastructure.DAO.PetsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return getPetById(id);
    }
}
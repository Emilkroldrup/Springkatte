package com.example.springkatte.pets.domain;

import java.util.ArrayList;

public class PetList {
    ArrayList<Pets> petList = new ArrayList<Pets>();

    public PetList() {

    }

    public void addPet(Pets pet) {
        petList.add(pet);
    }

    public void removePet(Pets pet) {
        petList.remove(pet);
    }

    public ArrayList<Pets> getPetList() {
        return petList;
    }

    public void setPetList(ArrayList<Pets> petList) {
        this.petList = petList;
    }

    @Override
    public String toString() {
        return "PetList{" +
                "petList=" + petList +
                '}';
    }
}

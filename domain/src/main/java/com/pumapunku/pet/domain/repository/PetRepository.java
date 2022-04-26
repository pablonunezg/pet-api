package com.pumapunku.pet.domain.repository;

import java.util.List;

import com.pumapunku.pet.domain.Pet;

public interface PetRepository
{
    Pet create(Pet pet);
    void update(Pet pet);
    void delete(String id);
    List<Pet> getPets();
}
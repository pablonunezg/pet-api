package com.pumapunku.pet.domain.repository;

import com.pumapunku.pet.domain.Pet;

public interface PetRepository
{
    Pet create(Pet pet);
    void update(Pet pet);
    void delete(String id);
}
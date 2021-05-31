package com.pumapunku.pet.application.impl;

import com.pumapunku.pet.application.CreatePetInteractor;
import com.pumapunku.pet.domain.Pet;
import com.pumapunku.pet.domain.repository.PetRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CreatePetInteractorImpl implements CreatePetInteractor
{
    private final transient PetRepository petRepository;

    @Inject
    public CreatePetInteractorImpl(PetRepository petRepository)
    {
        this.petRepository = petRepository;
    }

    @Override
    public Pet execute(Pet pet)
    {
        return petRepository.create(pet);
    }
}

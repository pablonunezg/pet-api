package com.pumapunku.pet.application.impl;

import com.pumapunku.pet.application.UpdatePetInteractor;
import com.pumapunku.pet.domain.Pet;
import com.pumapunku.pet.domain.repository.PetRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UpdatePetInteractorImpl implements UpdatePetInteractor
{
    private PetRepository petRepository;

    @Inject
    public UpdatePetInteractorImpl(PetRepository petRepository)
    {
        this.petRepository = petRepository;
    }

    @Override
    public void execute(Pet pet)
    {
        petRepository.update(pet);
    }
}

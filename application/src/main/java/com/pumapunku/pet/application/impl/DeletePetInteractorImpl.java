package com.pumapunku.pet.application.impl;

import com.pumapunku.pet.application.DeletePetInteractor;
import com.pumapunku.pet.domain.repository.PetRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DeletePetInteractorImpl implements DeletePetInteractor
{
    private final transient PetRepository petRepository;

    @Inject
    public DeletePetInteractorImpl(PetRepository petRepository)
    {
        this.petRepository = petRepository;
    }

    @Override
    public void execute(String id)
    {
        petRepository.delete(id);
    }
}

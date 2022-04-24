package com.pumapunku.pet.application.impl;

import com.pumapunku.pet.application.UpdatePetInteractor;
import com.pumapunku.pet.domain.Pet;
import com.pumapunku.pet.domain.repository.PetRepository;

import lombok.RequiredArgsConstructor;

import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class UpdatePetInteractorImpl implements UpdatePetInteractor
{
    private final transient PetRepository petRepository;

    @Override
    public void execute(Pet pet)
    {
        petRepository.update(pet);
    }
}

package com.pumapunku.pet.api.controller;

import com.pumapunku.pet.api.mapper.PetMapper;
import com.pumapunku.pet.api.request.PetRequest;
import com.pumapunku.pet.api.response.PetResponse;
import com.pumapunku.pet.application.CreatePetInteractor;
import com.pumapunku.pet.application.DeletePetInteractor;
import com.pumapunku.pet.application.UpdatePetInteractor;
import com.pumapunku.pet.domain.Pet;
import com.pumapunku.pet.domain.repository.PetRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pet")
@RequiredArgsConstructor
public class PetController
{
    private final transient CreatePetInteractor createPetInteractor;
    private final transient UpdatePetInteractor updatePetInteractor;
    private final transient DeletePetInteractor deletePetInteractor;
    private final transient PetRepository petRepository;

   
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PetResponse> getPets()
    {
        List<Pet> pets = petRepository.getPets();

        return pets.stream().map(p -> PetMapper.INSTANCE.toPetResponse(p))
        		            .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetResponse create(@Valid @RequestBody PetRequest petRequest)
    {
        Pet pet = PetMapper.INSTANCE.toPet(petRequest);
        return PetResponse.from(createPetInteractor.execute(pet));
    }

    @PutMapping("{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String petId, @RequestBody PetRequest petRequest)
    {
        petRequest.setId(petId);
        Pet pet = PetMapper.INSTANCE.toPet(petRequest);
        updatePetInteractor.execute(pet);
    }

    @DeleteMapping("{petId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String petId)
    {
        deletePetInteractor.execute(petId);
    }
}
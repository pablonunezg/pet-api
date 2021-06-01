package com.pumapunku.pet.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.pumapunku.pet.api.request.PetRequest;
import com.pumapunku.pet.api.response.PetResponse;
import com.pumapunku.pet.domain.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper
{
    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    Pet toPet(PetRequest petRequest);
    PetResponse toPetResponse(Pet pet);
}

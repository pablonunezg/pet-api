package com.pumapunku.pet.infrastructure.firestore;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pumapunku.pet.domain.Pet;

@ExtendWith(MockitoExtension.class)
class PetRepositoryImplTest
{
    @InjectMocks
    private PetRepositoryImpl petRepository;

    @Mock
    private PetFirestoreRepository PetpFirestoreRepository;

    @Test
    void create()
    {
        when(PetpFirestoreRepository.create(new PetCollection(null, "Tammy"))).thenReturn(new PetCollection("33", "Tammy"));

        Pet pet = petRepository.create(new Pet(null, "Tammy"));
        assertEquals(new Pet("33", "Tammy"), pet);
    }

    @Test
    void update()
    {
        petRepository.update(new Pet("1a", "Tammy"));
        verify(PetpFirestoreRepository, times(1)).update(new PetCollection("1a", "Tammy"));
    }

    @Test
    void delete()
    {
        petRepository.delete("1");
        verify(PetpFirestoreRepository, times(1)).delete("1");
    }
}

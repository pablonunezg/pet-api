package com.pumapunku.pet.infrastructure.firestore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PetCollectionTest
{
    @Test
    void createPetCollection()
    {
        PetCollection petCollection = new PetCollection("1", "Tammy");
        assertEquals("1", petCollection.getId());
        assertEquals("Tammy", petCollection.getName());
    }
}

package com.pumapunku.pet.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PetTest
{
    @Test
    void petAllConstructor()
    {
        Pet pet = new Pet("1122", "Laika");

        assertEquals("1122", pet.getId());
        assertEquals("Laika", pet.getName());
    }
}

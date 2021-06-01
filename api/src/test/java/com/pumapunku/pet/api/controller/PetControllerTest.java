package com.pumapunku.pet.api.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class PetControllerTest
{
    @Test
    void createPetController()
    {
        PetController petController = new PetController(null, null, null);
        assertNotNull(petController);
    }
}

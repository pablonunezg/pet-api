package com.pumapunku.pet.application.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class CreatePetInteractorImplTest
{
    @Test
    void newCreatePetInteractorImpl()
    {
        CreatePetInteractorImpl createPetInteractorImpl = new CreatePetInteractorImpl(null);
        assertNotNull(createPetInteractorImpl);
    }
}

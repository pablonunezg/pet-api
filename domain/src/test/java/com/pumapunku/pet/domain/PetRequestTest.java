package com.pumapunku.pet.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PetRequestTest
{
    @Test
    void createAlreadyExistsException()
    {
        PageRequest pageRequest = new PageRequest(22, 100);

        assertEquals(2200, pageRequest.offset());
    }
}

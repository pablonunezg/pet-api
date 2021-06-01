package com.pumapunku.pet.domain.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BusinessExceptionTest
{
    @Test
    void createBussinesException()
    {
        BusinessException businessException = new BusinessException("my Business expception");

        assertEquals("my Business expception", businessException.getMessage());
    }
}

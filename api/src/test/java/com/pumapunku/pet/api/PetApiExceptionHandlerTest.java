package com.pumapunku.pet.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pumapunku.pet.domain.exception.AlreadyExistsException;
import com.pumapunku.pet.domain.exception.BusinessException;
import com.pumapunku.pet.domain.exception.NotFoundException;

public class PetApiExceptionHandlerTest
{
    @Test
    void testAlreadyExistsException()
    {
        PetApiExceptionHandler petApiExceptionHandler = new PetApiExceptionHandler();
        ResponseEntity<Map<String, String>> res = petApiExceptionHandler.exceptions(new AlreadyExistsException("pet", "12"));
        
        assertEquals(HttpStatus.CONFLICT, res.getStatusCode());
        
        Map<String, String> responseMap = res.getBody();
        
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("message", "12 id already exists in the table");
        
        assertEquals(expectedMap, responseMap);
    }
    
    @Test
    void testNotFoundException()
    {
        PetApiExceptionHandler petApiExceptionHandler = new PetApiExceptionHandler();
        ResponseEntity<Map<String, String>> res = petApiExceptionHandler.exceptions(new NotFoundException("pet", "12"));
        
        assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
        
        Map<String, String> responseMap = res.getBody();
        
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("message", "12 not found!");
        
        assertEquals(expectedMap, responseMap);
    }
    
    @Test
    void testBusinessException()
    {
        PetApiExceptionHandler petApiExceptionHandler = new PetApiExceptionHandler();
        ResponseEntity<Map<String, String>> res = petApiExceptionHandler.exceptions(new BusinessException("invalid operation"));
        
        assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
        
        Map<String, String> responseMap = res.getBody();
        
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("message", "invalid operation");
        
        assertEquals(expectedMap, responseMap);
    }

}

package com.pumapunku.pet.api;

import com.pumapunku.pet.domain.exception.AlreadyExistsException;
import com.pumapunku.pet.domain.exception.BusinessException;
import com.pumapunku.pet.domain.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PetApiExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> exceptions(NotFoundException exception)
    {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("message", exception.getMessage());
        return new ResponseEntity<>(attributes, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> exceptions(AlreadyExistsException exception)
    {
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("message", exception.getMessage());
        return new ResponseEntity<>(attributes, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> exceptions(BusinessException exception)
    {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("message", exception.getMessage());
        return new ResponseEntity<>(attributes, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

}

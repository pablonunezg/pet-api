package com.pumapunku.pet.domain.exception;

public class BusinessException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    private String message;

    public BusinessException(String message)
    {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

}

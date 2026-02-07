package com.fun.BackendStuff.exception;

public class CategoryNameExistsException extends RuntimeException{
    public CategoryNameExistsException(String msg)
    {
        super(msg);
    }
}

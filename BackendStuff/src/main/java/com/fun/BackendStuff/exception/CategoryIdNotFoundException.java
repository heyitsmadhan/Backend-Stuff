package com.fun.BackendStuff.exception;

public class CategoryIdNotFoundException extends RuntimeException{
    public CategoryIdNotFoundException(String msg)
    {
        super(msg);
    }
}

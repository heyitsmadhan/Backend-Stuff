package com.fun.BackendStuff.exception;

public class ProductAlreadyExistsException extends RuntimeException{

    public ProductAlreadyExistsException(String msg)
    {
        super(msg);
    }
}

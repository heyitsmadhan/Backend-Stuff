package com.fun.BackendStuff.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIError {

    private int statusCode;
    private String ErrorMSG;
    private String requestURI;

}


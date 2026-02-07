package com.fun.BackendStuff.exception;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.http.HttpRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIError>methodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request)
    {
        APIError apiError = new APIError();
        apiError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiError.setErrorMSG(ex.getMessage());
        apiError.setRequestURI(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(apiError);
    }

    @ExceptionHandler(CategoryIdNotFoundException.class)
    public ResponseEntity<APIError>categoryIdNotExists(CategoryIdNotFoundException ex,HttpServletRequest request)
    {
        APIError apiError = new APIError();
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setErrorMSG(ex.getMessage());
        apiError.setRequestURI(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(CategoryNameExistsException.class)
    public ResponseEntity<APIError>categoryNameExistsException(CategoryNameExistsException ex,HttpServletRequest request)
    {
        APIError apiError = new APIError();
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setErrorMSG(ex.getMessage());
        apiError.setRequestURI(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError>exception(Exception ex,HttpServletRequest request)
    {
        APIError apiError = new APIError();
        apiError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiError.setErrorMSG(ex.getMessage());
        apiError.setRequestURI(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}

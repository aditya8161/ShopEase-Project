package com.ShopEase.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobleException
{
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorData> handleUserNotFoundException(UserNotFoundException ex, WebRequest request)
    {
        String path = request.getDescription(false).replace("uri=", "");

        ErrorData error = ErrorData.builder()
                .message(ex.getMessage())
                .errorPath(path)
                .time(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND)
                .build();
        log.error("Error : {}{}",ex.getMessage(),error);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorData> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request)
    {
        String path = request.getDescription(false).replace("uri=", "");

        Map<String,String> errorMap  =new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(),error.getDefaultMessage());
        });

        ErrorData error = ErrorData.builder()
                .message(ex.getMessage())
                .errorMap(errorMap)
                .errorPath(path)
                .time(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .build();
        log.error("Error : {}",errorMap);
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorData> handleRuntimeException(RuntimeException ex, WebRequest request)
    {
        String path = request.getDescription(false).replace("uri=", "");

        ErrorData error = ErrorData.builder()
                .message(ex.getMessage())
                .errorPath(path)
                .time(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        log.error("Error : {}{}",ex.getMessage(),error);
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

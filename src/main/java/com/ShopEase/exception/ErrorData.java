package com.ShopEase.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class ErrorData
{
    private String message;
    private String errorPath;
    private LocalDateTime time;
    private HttpStatus status;

    private Map<String,String> errorMap = new HashMap<>();

}

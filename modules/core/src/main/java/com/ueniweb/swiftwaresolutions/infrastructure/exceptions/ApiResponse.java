package com.ueniweb.swiftwaresolutions.infrastructure.exceptions;

import lombok.Data;

import java.util.Optional;

@Data
public class ApiResponse <T>{
    private String status;
    private T data;
    private String message;
}

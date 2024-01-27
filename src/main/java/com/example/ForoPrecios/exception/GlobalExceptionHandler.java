package com.example.ForoPrecios.exception;

import com.example.ForoPrecios.model.dto.ApiResponseDTO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

//Detectamos todas las excepciones que se produzcan en tiempo de ejecucion
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    //Manejo de errores del validador de formularios
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidArguments(MethodArgumentNotValidException exception, WebRequest webRequest){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            errors.put(((FieldError) error).getField(), error.getDefaultMessage());
        }); 
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    
    //Con este metodo manejamos las excepciones ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){ 
        ApiResponseDTO apiResponse = new ApiResponseDTO(exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    
    //Manejar excepciones de conflictos
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiResponseDTO> handleConflictException(ConflictException exception, WebRequest webRequest){ 
        ApiResponseDTO apiResponse = new ApiResponseDTO(exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
    }
    
    //Manejar error de falta de parametros 
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponseDTO> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception, WebRequest webRequest) {
        ApiResponseDTO apiResponse = new ApiResponseDTO("La url no existe o faltan parametros", webRequest.getDescription(false));
        return ResponseEntity.badRequest().body(apiResponse);
    }
    
    //Manejar cualquier excepcion que se genere
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDTO> handleException(Exception exception, WebRequest webRequest){ 
        ApiResponseDTO apiResponse = new ApiResponseDTO(exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}

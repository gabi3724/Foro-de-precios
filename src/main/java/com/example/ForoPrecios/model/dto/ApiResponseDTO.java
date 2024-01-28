package com.example.ForoPrecios.model.dto;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponseDTO {
    
    private Date tiempo = new Date();
    private String message;
    private String url;

    public ApiResponseDTO(String message, String url) {
        this.message = message;
        this.url = url.replace("uri=", "");
    }
    
}

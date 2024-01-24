package com.example.ForoPrecios.dto;

import com.example.ForoPrecios.advice.Unique;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    
    @NotEmpty(message = "El nombre no puede estar vacio")
    @Size(min = 2, message = "El nombre debe tener al menos dos caracteres")
    private String nombre;
    
    @NotEmpty(message = "El apellido no puede estar vacio")
    @Size(min = 2, message = "El apellido debe tener al menos dos caracteres")
    private String apellido;
    
    @Email(message = "El mail debe ser valido")
    @Unique(message = "El mail ya se encuentra registrado")
    private String email;
    
    @NotEmpty(message = "La contraseña no puede estar vacia")
    @Size(min = 6, message = "La contraseña debe tener al menos seis caracteres")
    private String contraseña;
    
}

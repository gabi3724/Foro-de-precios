package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ConflictException;
import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.UsuarioDTO;
import com.example.ForoPrecios.model.entity.Usuario;
import com.example.ForoPrecios.service.IUsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/precios")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.findUsuario(id); 
        if(usuario == null){
            throw new ResourceNotFoundException("Usuario", "id", id);
        }
        return usuario;
    }
    
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = usuarioService.getUsuarios(); 
        if(usuarios == null || usuarios.isEmpty()){
            throw new ResourceNotFoundException("Usuarios");
        }
        return usuarios;
    }
    
    @PostMapping("/usuarios/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        Boolean existe = usuarioService.existeEmail(usuarioDTO.getEmail());
        if(existe){
            throw new ConflictException("El mail ya existe en la base de datos");
        }
        Usuario usuario = Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .email(usuarioDTO.getEmail())
                .contraseña(usuarioDTO.getContraseña())
                .build();
        usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    @PutMapping("/usuarios/editar/{id}")
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioService.findUsuario(id);
        if(usuario == null){
            throw new ResourceNotFoundException("Usuario","id",id);
        }
        String email = usuarioDTO.getEmail();
        //Chequear si el mail que se quiere insertar ya existe en la base de datos y en caso de existir si pertenece a el usuario
        if((usuarioService.existeEmail(email)) && (!email.equals(usuario.getEmail()))){
            throw new ConflictException("El mail ya existe en la base de datos");
        }
        usuario = Usuario.builder()
            .usuarioId(id)
            .nombre(usuarioDTO.getNombre())
            .apellido(usuarioDTO.getApellido())
            .email(usuarioDTO.getEmail())
            .contraseña(usuarioDTO.getContraseña())
            .build();
        usuarioService.editUsuario(usuario);
        return usuario;
    }
    
    @DeleteMapping("/usuarios/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){
        if(usuarioService.findUsuario(id) == null){
            throw new ResourceNotFoundException("Usuario","id",id);
        }
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>("Usuario borrado exitosamente", HttpStatus.NO_CONTENT);
    }
    
}
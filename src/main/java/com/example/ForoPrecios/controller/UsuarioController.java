package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.UsuarioDTO;
import com.example.ForoPrecios.model.entity.Usuario;
import com.example.ForoPrecios.model.record.PostRecordByUser;
import com.example.ForoPrecios.service.IUsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        return usuarioService.findUsuario(id).orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
    }
    
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    //Probar caso con mail repetido
    @PostMapping("/usuarios/crear")
    public ResponseEntity<?> crearUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                usuarioService.saveUsuario(
                    Usuario.builder()
                    .nombre(usuarioDTO.getNombre())
                    .apellido(usuarioDTO.getApellido())
                    .email(usuarioDTO.getEmail())
                    .contraseña(usuarioDTO.getContraseña())
                    .build()));
    }
    
    @PutMapping("/usuarios/editar/{id}")
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDTO usuarioDTO){

        return usuarioService.editUsuario(
                usuarioService.findUsuario(id)
                    .map(u -> Usuario.builder()
                            .usuarioId(id)
                            .nombre(usuarioDTO.getNombre())
                            .apellido(usuarioDTO.getApellido())
                            .email(usuarioDTO.getEmail())
                            .contraseña(usuarioDTO.getContraseña())
                            .build())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario","id",id))
        );
    }
    
    @DeleteMapping("/usuarios/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id){

        return Optional.ofNullable(usuarioService.deleteUsuario(id))
                .filter(filasBorradas -> filasBorradas > 0)
                .map(filasBorradas -> new ResponseEntity<>("Usuario borrado exitosamente", HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id",id));
    }

    @GetMapping("usuarios/reporte/{id}")
    public ResponseEntity<?> reporteUsuario(@PathVariable Long id){
        return usuarioService.reporteUsuario(id)
                .map(reporte -> new ResponseEntity<PostRecordByUser>(reporte, HttpStatus.OK))
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", id));
    }
    
}
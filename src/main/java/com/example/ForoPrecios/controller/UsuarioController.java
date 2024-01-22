package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.model.Usuario;
import com.example.ForoPrecios.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        return usuarioService.findUsuario(id);
    }
    
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }
    
    @PostMapping("/usuarios/crear")
    public void crearUsuario(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
    }
    
    @PutMapping("/usuarios/editar/{id}")
    public void editarUsuario(@PathVariable Long id){
        usuarioService.editUsuario(null);
    }
    
    @DeleteMapping("/usuarios/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }
    
}

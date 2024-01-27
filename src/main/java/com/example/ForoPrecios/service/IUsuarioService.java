package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.entity.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    public Usuario findUsuario(Long id);
    public void saveUsuario(Usuario usuario);
    public void deleteUsuario(Long id);
    public List<Usuario> getUsuarios();
    public void editUsuario(Usuario usuario);
    public boolean existeEmail(String email);
    public boolean existeId(Long id);
    
}

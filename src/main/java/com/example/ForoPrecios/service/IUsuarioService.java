package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.entity.Usuario;
import com.example.ForoPrecios.model.record.PostRecordByUser;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    
    public Optional<Usuario> findUsuario(Long id);
    public Usuario saveUsuario(Usuario usuario);
    public int deleteUsuario(Long id);
    public List<Usuario> getUsuarios();
    public Usuario editUsuario(Usuario usuario);
    public boolean existeEmail(String email);
    public boolean existeId(Long id);
    public Optional<PostRecordByUser> reporteUsuario(Long id);
    
}

package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Usuario;
import com.example.ForoPrecios.repository.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private IUsuarioRepository usuarioRepo;
    
    @Override
    public Usuario findUsuario(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void editUsuario(Usuario usuario) {
        this.saveUsuario(usuario);
    }   
    
}
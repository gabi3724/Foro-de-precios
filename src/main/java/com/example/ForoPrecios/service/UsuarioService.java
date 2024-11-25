package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.entity.Usuario;
import com.example.ForoPrecios.model.record.PostRecord;
import com.example.ForoPrecios.model.record.PostRecordByUser;
import com.example.ForoPrecios.repository.IUsuarioRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Autowired
    private IPostService postService;
    
    @Override
    public Optional<Usuario> findUsuario(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) { return usuarioRepo.save(usuario);
    }

    @Override
    @Transactional
    public int deleteUsuario(Long id) {
        return usuarioRepo.deleteUser(id);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario editUsuario(Usuario usuario) {
        return this.saveUsuario(usuario);
    }   

    @Override
    public boolean existeEmail(String email) {
        return this.usuarioRepo.findByEmail(email).isPresent();
    }
    
    @Override
    public boolean existeId(Long id) {
        return this.findUsuario(id).isPresent();
    }

    public Optional<PostRecordByUser> reporteUsuario(Long id) {
        return usuarioRepo.findById(id)
                .map(user -> {
                    // Obtener los posts asociados al usuario
                    List<PostRecord> postsRecords = postService.postsUsuario(user.getUsuarioId()).stream()
                            .map(post -> new PostRecord(
                                    post.getLocal().getNombre(),
                                    post.getProducto().getNombre(),
                                    post.getCategoria().getNombre(),
                                    post.getPrecio()
                            ))
                            .collect(Collectors.toList());
                    // Retornar un PostRecordByUser con la información del usuario y los posts
                    return Optional.of(new PostRecordByUser(postsRecords, user.getNombre()+" "+user.getApellido(), postsRecords.size()));
                })
                .orElse(Optional.empty());  // Si no se encuentra el usuario, retornamos null
    }

}
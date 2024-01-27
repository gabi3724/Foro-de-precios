package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.entity.Comentario;
import com.example.ForoPrecios.repository.IComentarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService implements IComentarioService {
    
    @Autowired
    private IComentarioRepository comentarioRepo;
    
    @Override
    public Comentario findComentario(Long id) {
        return comentarioRepo.findById(id).orElse(null);
    }

    @Override
    public void saveComentario(Comentario comentario) {
        comentarioRepo.save(comentario);
    }

    @Override
    public void deleteComentario(Long id) {
        comentarioRepo.deleteById(id);
    }

    @Override
    public List<Comentario> getComentarios() {
        return comentarioRepo.findAll();
    }

    @Override
    public void editComentario(Comentario comentario) {
        this.saveComentario(comentario);
    }   
    
}

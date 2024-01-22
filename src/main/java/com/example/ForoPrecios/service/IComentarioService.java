package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Comentario;
import java.util.List;

public interface IComentarioService {
 
    public Comentario findComentario(Long id);
    public void saveComentario(Comentario comentario);
    public void deleteComentario(Long id);
    public List<Comentario> getComentarios();
    public void editComentario(Comentario comentario);
   
}

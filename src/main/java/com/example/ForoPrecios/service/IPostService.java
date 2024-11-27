package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.entity.Comentario;
import com.example.ForoPrecios.model.entity.Post;
import com.example.ForoPrecios.model.record.PostFindRecord;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface IPostService {
    
    public Optional<Post> findPost(Long id);
    public void savePost(Post post);
    public void deletePost(Long id);
    public List<Post> getPosts();
    public void editPost(Post post);
    public List<Post> postsUsuario(Long id_usuario);
    public List<Post> postsProducto(Long id_producto);
    public List<Post> postsCategoria(Long id_categoria);
    public List<Post> postsLocal(Long id_local);
    public List<Comentario> getComentariosPost(Long id);
    public List<PostFindRecord> findPostByTime(Instant fecha);
    
}

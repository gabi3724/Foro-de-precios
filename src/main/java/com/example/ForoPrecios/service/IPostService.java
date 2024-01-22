package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Post;
import java.util.List;

public interface IPostService {
    
    public Post findPost(Long id);
    public void savePost(Post post);
    public void deletePost(Long id);
    public List<Post> getPosts();
    public void editPost(Post post);
    public List<Post> PostsUsuario(Long id_usuario);
    public List<Post> PostsProducto(Long id_producto);
    public List<Post> PostsCategoria(Long id_categoria);
    public List<Post> PostsLocal(Long id_local);
    public List<Post> PostsBusqueda(String atributo, String buscar);
    
}

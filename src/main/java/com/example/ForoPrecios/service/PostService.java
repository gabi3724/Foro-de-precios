package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Post;
import com.example.ForoPrecios.repository.IPostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    
    @Autowired
    private IPostRepository postRepo;
    
    @Override
    public Post findPost(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public void savePost(Post post) {
        postRepo.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public void editPost(Post post) {
        this.savePost(post);
    }   

    @Override
    public List<Post> PostsUsuario(Long id_usuario) {
        return postRepo.obtenerPostsDeUsuario(id_usuario);
    }

    @Override
    public List<Post> PostsProducto(Long id_producto) {
        return postRepo.obtenerPostsDeProdcuto(id_producto);
    }

    @Override
    public List<Post> PostsCategoria(Long id_categoria) {
        return postRepo.obtenerPostsDeCategoria(id_categoria);
    }

    @Override
    public List<Post> PostsLocal(Long id_local) {
        return postRepo.obtenerPostsDeLocal(id_local);
    }

    @Override
    public List<Post> PostsBusqueda(String atributo, String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
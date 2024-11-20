package com.example.ForoPrecios.service;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.entity.Comentario;
import com.example.ForoPrecios.model.entity.Post;
import com.example.ForoPrecios.repository.IPostRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    
    @Autowired
    private IPostRepository postRepo;
    
    @Override
    public Optional<Post> findPost(Long id) {
        return postRepo.findById(id);
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
        return (List<Post>) postRepo.findAll();
    }

    @Override
    public void editPost(Post post) {
        this.savePost(post);
    }   

    @Override
    public List<Post> PostsUsuario(Long id_usuario) {
        return postRepo.findByUsuarioUsuarioId(id_usuario);
    }

    @Override
    public List<Post> PostsProducto(Long productoId) {
        return postRepo.findByProductoProductoId(productoId);
    }

    @Override
    public List<Post> PostsCategoria(Long categoriaId) {
        return postRepo.findByCategoriaCategoriaId(categoriaId);
    }

    @Override
    public List<Post> PostsLocal(Long localId) {
        return postRepo.findByLocalLocalId(localId);
    }

    @Override
    public List<Comentario> getComentariosPost(Long postId) {
        Optional<Post> post = this.findPost(postId);
        if(post.isPresent()) {
            return post.get().getComentarios();
        }else{
            throw new ResourceNotFoundException("Post","id",postId);
        }
    }

    @Override
    public List<Post> PostsBusqueda(String atributo, String buscar) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
package com.example.ForoPrecios.service;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.entity.Comentario;
import com.example.ForoPrecios.model.entity.Post;
import com.example.ForoPrecios.model.enums.Antiguedad;
import com.example.ForoPrecios.model.record.PostFindRecord;
import com.example.ForoPrecios.repository.IPostRepository;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Post> postsUsuario(Long usuarioId) {
        return postRepo.findByUsuarioUsuarioId(usuarioId);
    }

    @Override
    public List<Post> postsProducto(Long productoId) {
        return postRepo.findByProductoProductoId(productoId);
    }

    @Override
    public List<Post> postsCategoria(Long categoriaId) {
        return postRepo.findByCategoriaCategoriaId(categoriaId);
    }

    @Override
    public List<Post> postsLocal(Long localId) {
        return postRepo.findByLocalLocalId(localId);
    }

    @Override
    public List<Comentario> getComentariosPost(Long postId) {
        return this.findPost(postId)
                .map(Post::getComentarios)
                .orElseThrow(() -> new ResourceNotFoundException("Post","id",postId));
    }

    @Override
    public List<PostFindRecord> findPostByTime(Instant fecha) {
        return postRepo.findAll()
                .stream()
                .filter(post -> post.getFecha().isAfter(fecha))
                .map(p -> new PostFindRecord(
                                p.getProducto().getNombre(),
                                p.getPrecio(),
                                p.getFecha().atZone(ZoneId.of("America/Argentina/Buenos_Aires")),
                                p.getUsuario().getNombre()+" "+p.getUsuario().getApellido(),
                                p.getLocal().getNombre() +' '+p.getLocal().getDireccion(),
                                p.getCategoria().getNombre()
                )).toList();
    }
    
}
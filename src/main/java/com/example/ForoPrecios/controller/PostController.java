package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.PostDTO;
import com.example.ForoPrecios.model.entity.Post;
import com.example.ForoPrecios.service.IPostService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PostController {
    
    @Autowired
    private IPostService postService;
    
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id){
        Post post = postService.findPost(id);
        if(post == null){
            throw new ResourceNotFoundException("Post","id",id);
        }
        return post;
    }
    
    @GetMapping("/posts")
    public List<Post> getPosts(){
        List<Post> posts = postService.getPosts();
        if(posts == null || posts.isEmpty()){
            throw new ResourceNotFoundException("Posts");
        }
        return posts;
    }
    
    @PostMapping("/posts/crear")
    public ResponseEntity<?> crearPost(@RequestBody @Valid PostDTO postDTO){
        Post post = Post.builder()
                .precio(postDTO.getPrecio())
                .fecha(postDTO.getFecha())
                .producto(postDTO.getProducto())
                .categoria(postDTO.getCategoria())
                .local(postDTO.getLocal())
                .usuario(postDTO.getUsuario())
                .build();
        postService.savePost(post);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    
    @PutMapping("/posts/editar/{id}")
    public Post editarPost(@PathVariable Long id, @RequestBody @Valid PostDTO postDTO){
        Post post = postService.findPost(id);
        if(post == null){
            throw new ResourceNotFoundException("Post","id",id);
        }
        post = Post.builder()
                .id_post(id)
                .precio(postDTO.getPrecio())
                .fecha(postDTO.getFecha())
                .producto(postDTO.getProducto())
                .categoria(postDTO.getCategoria())
                .local(postDTO.getLocal())
                .usuario(postDTO.getUsuario())
                .build();
        postService.editPost(post);
        return post;
    }
    
    @DeleteMapping("/posts/eliminar/{id}")
    public ResponseEntity<?> eliminarPost(@PathVariable Long id){
        Post post = postService.findPost(id);
        if(post == null){
            throw new ResourceNotFoundException("Post","id",id);
        }
        postService.deletePost(id);
        return new ResponseEntity<>("Local borrado exitosamente", HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/posts/usuario/{id_usuario}")
    public List<Post> getPostUsuario(@PathVariable Long id_usuario){
        return postService.PostsUsuario(id_usuario);
    }
    
    @GetMapping("/posts/producto/{id_producto}")
    public List<Post> getPostProducto(@PathVariable Long id_producto){
        return postService.PostsProducto(id_producto);
    }
    
    @GetMapping("/posts/categoria/{id_categoria}")
    public List<Post> getPostCategoria(@PathVariable Long id_categoria){
        return postService.PostsCategoria(id_categoria);
    }
    
    @GetMapping("/posts/local/{id_local}")
    public List<Post> getPostLocal(@PathVariable Long id_local){
        return postService.PostsLocal(id_local);
    }
    
    @GetMapping("/posts/busqueda")
    public List<Post> getBuscarPosts(@RequestParam String atributo, @RequestParam String buscar){
        return postService.PostsBusqueda(atributo, buscar);
    }
    
}
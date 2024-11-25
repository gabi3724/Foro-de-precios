package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.PostDTO;
import com.example.ForoPrecios.model.entity.Comentario;
import com.example.ForoPrecios.model.entity.Post;
import com.example.ForoPrecios.model.record.PostRecord;
import com.example.ForoPrecios.service.IPostService;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/precios")
public class PostController {
    
    @Autowired
    private IPostService postService;

    //Probar
    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id){
        return postService.findPost(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
    }

    //Probar
    @GetMapping("/posts")
    public List<Post> getPosts(){
        List<Post> posts = postService.getPosts();
        if(posts.isEmpty()){
            throw new ResourceNotFoundException("Posts");
        }
        return posts;
    }
    
    @PostMapping("/posts/crear")
    public ResponseEntity<?> crearPost(@RequestBody @Valid PostDTO postDTO){
        Post post = Post.builder()
                    .precio(postDTO.getPrecio())
                    .fecha(LocalDateTime.now())
                    .producto(postDTO.getProducto())
                    .categoria(postDTO.getCategoria())
                    .local(postDTO.getLocal())
                    .usuario(postDTO.getUsuario())
                    .build();
        postService.savePost(post);
        return new ResponseEntity<>("Post creado correctamente", HttpStatus.CREATED);
    }
    
    @PutMapping("/posts/editar/{id}")
    public Post editarPost(@PathVariable Long id, @RequestBody @Valid PostDTO postDTO){
        if(postService.findPost(id).isEmpty()){
            throw new ResourceNotFoundException("Post","id",id);
        }
        Post nuevoPost = Post.builder()
                .postId(id)
                .precio(postDTO.getPrecio())
                .fecha(LocalDateTime.now())
                .producto(postDTO.getProducto())
                .categoria(postDTO.getCategoria())
                .local(postDTO.getLocal())
                .usuario(postDTO.getUsuario())
                .build();
        postService.editPost(nuevoPost);
        return nuevoPost;
    }
    
    @DeleteMapping("/posts/eliminar/{id}")
    public ResponseEntity<?> eliminarPost(@PathVariable Long id){
        if(postService.findPost(id).isEmpty()){
            throw new ResourceNotFoundException("Post","id",id);
        }
        postService.deletePost(id);
        return new ResponseEntity<>("Post borrado exitosamente", HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/posts/usuario/{id_usuario}")
    public List<Post> getPostUsuario(@PathVariable Long id_usuario){
        return postService.postsUsuario(id_usuario);
    }

    @GetMapping("/posts/usuario/modificado/{id_usuario}")
    public List<PostRecord> getPostUsuarioModificado(@PathVariable Long id_usuario){
        return null;
    }
    
    @GetMapping("/posts/producto/{id_producto}")
    public List<Post> getPostProducto(@PathVariable Long id_producto){
        return postService.postsProducto(id_producto);
    }
    
    @GetMapping("/posts/categoria/{id_categoria}")
    public List<Post> getPostCategoria(@PathVariable Long id_categoria){ return postService.postsCategoria(id_categoria); }
    
    @GetMapping("/posts/local/{id_local}")
    public List<Post> getPostLocal(@PathVariable Long id_local){
        return postService.postsLocal(id_local);
    }

    @GetMapping("/posts/comentarios/{id_post}")
    public List<Comentario> getComentariosPost(@PathVariable Long id_post){
        return postService.getComentariosPost(id_post);
    }

    @GetMapping("/posts/busqueda")
    public List<Post> getBuscarPosts(@RequestParam String atributo, @RequestParam String buscar){
        return postService.postsBusqueda(atributo, buscar);
    }
    
}
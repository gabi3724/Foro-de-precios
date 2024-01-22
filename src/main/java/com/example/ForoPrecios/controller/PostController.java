package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.model.Post;
import com.example.ForoPrecios.service.IPostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
        return postService.findPost(id);
    }
    
    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postService.getPosts();
    }
    
    @PostMapping("/posts/crear")
    public void crearPost(@RequestBody Post post){
        postService.savePost(post);
    }
    
    @PutMapping("/posts/editar/{id}")
    public void editarPost(@PathVariable Long id){
        postService.editPost(null);
    }
    
    @DeleteMapping("/posts/eliminar/{id}")
    public void eliminarPost(@PathVariable Long id){
        postService.deletePost(id);
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

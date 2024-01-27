package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.model.dto.ProductoDTO;
import com.example.ForoPrecios.model.entity.Producto;
import com.example.ForoPrecios.service.IProductoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/productos/{id}")
    public Producto getProducto(@PathVariable Long id){
        return productoService.findProducto(id);
    }
    
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }
    
    @PostMapping("/productos/crear")
    public void crearProducto(@RequestBody @Valid ProductoDTO productoDTO){
        Producto producto = Producto.builder().nombre(productoDTO.getNombre()).marca(productoDTO.getMarca()).build();
        productoService.saveProducto(producto);
    }
    
    @PutMapping("/productos/editar/{id}")
    public void editarProducto(@PathVariable Long id){
        productoService.editProducto(null);
    }
    
    @DeleteMapping("/productos/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
    }
    
}
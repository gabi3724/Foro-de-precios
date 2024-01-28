package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.ProductoDTO;
import com.example.ForoPrecios.model.entity.Producto;
import com.example.ForoPrecios.service.IProductoService;
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

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/productos/{id}")
    public ResponseEntity<?> getProducto(@PathVariable Long id){
        Producto producto = productoService.findProducto(id);
        if(producto == null){
            throw new ResourceNotFoundException("Producto","id",id);
        } 
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
    
    @GetMapping("/productos")
    public ResponseEntity<?> getProductos(){
        List<Producto> productos = productoService.getProductos(); 
        if(productos == null || productos.isEmpty()){
            throw new ResourceNotFoundException("Productos");
        }
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    
    @PostMapping("/productos/crear")
    public ResponseEntity<?> crearProducto(@RequestBody @Valid ProductoDTO productoDTO){
        Producto producto = Producto.builder().nombre(productoDTO.getNombre()).marca(productoDTO.getMarca()).build();
        try{
            productoService.saveProducto(producto);
            return new ResponseEntity<>(producto, HttpStatus.CREATED);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @PutMapping("/productos/editar/{id}")
    public ResponseEntity<?> editarProducto(@PathVariable Long id, @RequestBody @Valid ProductoDTO productoDTO){
        Producto producto = productoService.findProducto(id);
        if(producto == null){
            throw new ResourceNotFoundException("Producto","id",id); 
        }
        producto.setId_producto(id);
        producto.setNombre(productoDTO.getNombre());
        producto.setMarca(productoDTO.getMarca());
        try{
            productoService.editProducto(producto);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @DeleteMapping("/productos/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
        Producto producto = productoService.findProducto(id);
        if(producto == null){
            throw new ResourceNotFoundException("Producto","id",id); 
        }
        productoService.deleteProducto(id);
        return new ResponseEntity<>("Producto borrado exitosamente", HttpStatus.OK);
    }
    
}
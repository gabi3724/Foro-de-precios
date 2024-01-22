package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Producto;
import com.example.ForoPrecios.repository.IProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository productoRepo;
    
    @Override
    public Producto findProducto(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }   
    
}
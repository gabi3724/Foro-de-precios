package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Producto;
import java.util.List;

public interface IProductoService {
    
    public Producto findProducto(Long id);
    public void saveProducto(Producto producto);
    public void deleteProducto(Long id);
    public List<Producto> getProductos();
    public void editProducto(Producto producto);
    
}

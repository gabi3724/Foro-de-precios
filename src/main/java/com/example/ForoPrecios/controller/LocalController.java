package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.model.Local;
import com.example.ForoPrecios.service.ILocalService;
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
public class LocalController {
    
    @Autowired
    private ILocalService localService;
    
    @GetMapping("/locals/{id}")
    public Local getLocal(@PathVariable Long id){
        return localService.findLocal(id);
    }
    
    @GetMapping("/locals")
    public List<Local> getLocals(){
        return localService.getLocals();
    }
    
    @PostMapping("/locals/crear")
    public void crearLocal(@RequestBody Local local){
        localService.saveLocal(local);
    }
    
    @PutMapping("/locals/editar/{id}")
    public void editarLocal(@PathVariable Long id){
        localService.editLocal(null);
    }
    
    @DeleteMapping("/locals/eliminar/{id}")
    public void eliminarLocal(@PathVariable Long id){
        localService.deleteLocal(id);
    }
    
}
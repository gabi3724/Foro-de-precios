package com.example.ForoPrecios.controller;

import com.example.ForoPrecios.exception.ResourceNotFoundException;
import com.example.ForoPrecios.model.dto.LocalDTO;
import com.example.ForoPrecios.model.entity.Local;
import com.example.ForoPrecios.service.ILocalService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/precios")
public class LocalController {
    
    @Autowired
    private ILocalService localService;
    
    @GetMapping("/locals/{id}")
    public Local getLocal(@PathVariable Long id){
        Local local = localService.findLocal(id);
        if(local == null){
            throw new ResourceNotFoundException("Local","id",id);
        } 
        return local;
    }
    
    @GetMapping("/locales")
    public List<Local> getLocals(){
        List<Local> locales = localService.getLocals(); 
        if(locales == null || locales.isEmpty()){
            throw new ResourceNotFoundException("Locals");
        }
        return locales;
    }
    
    @PostMapping("/locals/crear")
    public ResponseEntity<?> crearLocal(@RequestBody @Valid LocalDTO localDTO){
        Local local = Local.builder()
                .nombre(localDTO.getNombre())
                .direccion(localDTO.getDireccion())
                .build();
        localService.saveLocal(local);
        return new ResponseEntity<>(local, HttpStatus.CREATED);
    }
    
    @PutMapping("/locals/editar/{id}")
    public Local editarLocal(@PathVariable Long id, @RequestBody @Valid LocalDTO localDTO){
        Local local = localService.findLocal(id);
        if(local == null){
            throw new ResourceNotFoundException("Local","id",id); 
        }
        local.setId_local(id);
        local.setNombre(localDTO.getNombre());
        local.setDireccion(localDTO.getDireccion());
        localService.editLocal(local);
        return local;
    }
    
    @DeleteMapping("/locals/eliminar/{id}")
    public ResponseEntity<?> eliminarLocal(@PathVariable Long id){
        Local local = localService.findLocal(id);
        if(local == null){
            throw new ResourceNotFoundException("Local","id",id); 
        }
        localService.deleteLocal(id);
        return new ResponseEntity<>("Local borrado exitosamente", HttpStatus.NO_CONTENT);
    }
    
}
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {
    
    @Autowired
    private ILocalService localService;
    
    @GetMapping("/locals/{id}")
    public ResponseEntity<?> getLocal(@PathVariable Long id){
        Local local = localService.findLocal(id);
        if(local == null){
            throw new ResourceNotFoundException("Local","id",id);
        } 
        return new ResponseEntity<>(local, HttpStatus.OK);
    }
    
    @GetMapping("/locals")
    public ResponseEntity<?> getLocals(){
        List<Local> locals = localService.getLocals(); 
        if(locals == null || locals.isEmpty()){
            throw new ResourceNotFoundException("Locals");
        }
        return new ResponseEntity<>(locals, HttpStatus.OK);
    }
    
    @PostMapping("/locals/crear")
    public ResponseEntity<?> crearLocal(@RequestBody @Valid LocalDTO localDTO){
        Local local = Local.builder().nombre(localDTO.getNombre()).direccion(localDTO.getDireccion()).build();
        try{
            localService.saveLocal(local);
            return new ResponseEntity<>(local, HttpStatus.CREATED);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @PutMapping("/locals/editar/{id}")
    public ResponseEntity<?> editarLocal(@PathVariable Long id, @RequestBody @Valid LocalDTO localDTO){
        Local local = localService.findLocal(id);
        if(local == null){
            throw new ResourceNotFoundException("Local","id",id); 
        }
        local.setId_local(id);
        local.setNombre(localDTO.getNombre());
        local.setDireccion(localDTO.getDireccion());
        try{
            localService.editLocal(local);
            return new ResponseEntity<>(local, HttpStatus.OK);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    @DeleteMapping("/locals/eliminar/{id}")
    public ResponseEntity<?> eliminarLocal(@PathVariable Long id){
        Local local = localService.findLocal(id);
        if(local == null){
            throw new ResourceNotFoundException("Local","id",id); 
        }
        localService.deleteLocal(id);
        return new ResponseEntity<>("Local borrado exitosamente", HttpStatus.OK);
    }
    
}
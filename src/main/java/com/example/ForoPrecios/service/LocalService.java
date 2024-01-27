package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.entity.Local;
import com.example.ForoPrecios.repository.ILocalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalService implements ILocalService {
    
    @Autowired
    private ILocalRepository localRepo;
    
    @Override
    public Local findLocal(Long id) {
        return localRepo.findById(id).orElse(null);
    }

    @Override
    public void saveLocal(Local local) {
        localRepo.save(local);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepo.deleteById(id);
    }

    @Override
    public List<Local> getLocals() {
        return localRepo.findAll();
    }

    @Override
    public void editLocal(Local local) {
        this.saveLocal(local);
    }   
    
}
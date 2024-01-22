package com.example.ForoPrecios.service;

import com.example.ForoPrecios.model.Local;
import java.util.List;

public interface ILocalService {
 
    public Local findLocal(Long id);
    public void saveLocal(Local local);
    public void deleteLocal(Long id);
    public List<Local> getLocals();
    public void editLocal(Local local);    
    
}

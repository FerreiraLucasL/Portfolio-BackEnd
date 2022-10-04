
package com.portfolio.backend.service;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.interfaces.IEducacionServ;
import com.portfolio.backend.repository.IEducacionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpEducacionServ implements IEducacionServ{
    @Autowired IEducacionRepo ieducacionRepo;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> edu = ieducacionRepo.findAll();
        return edu;
    }

    @Override
    public void saveEducacion(Educacion edu) {
        ieducacionRepo.save(edu);
    }

    @Override
    public void deleteEducacion(Long id) {
        ieducacionRepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion edu = ieducacionRepo.findById(id).orElse(null);
        return edu;
    }
            
}

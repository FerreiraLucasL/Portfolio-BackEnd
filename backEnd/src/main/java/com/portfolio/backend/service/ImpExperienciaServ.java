
package com.portfolio.backend.service;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.interfaces.IExperienciaServ;
import com.portfolio.backend.repository.IExperienciaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienciaServ implements IExperienciaServ{
    @Autowired IExperienciaRepo iexperienciaRepo;
    
    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> exp = iexperienciaRepo.findAll();
        return exp;
    }

    @Override
    public void saveExperiencia(Experiencia exp) {
        iexperienciaRepo.save(exp);
    }

    @Override
    public void deleteExperiencia(Long id) {
        iexperienciaRepo.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia exp = iexperienciaRepo.findById(id).orElse(null);
        return exp;
    }
    
}

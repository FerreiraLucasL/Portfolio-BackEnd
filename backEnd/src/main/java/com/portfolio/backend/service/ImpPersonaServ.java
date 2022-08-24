
package com.portfolio.backend.service;

import com.portfolio.backend.entity.Persona;
import java.util.List;
import org.springframework.stereotype.Service;
import com.portfolio.backend.interfaces.IPersonaServ;
import com.portfolio.backend.repository.IPersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ImpPersonaServ implements IPersonaServ{
    @Autowired IPersonaRepo iPersonaRepo;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = iPersonaRepo.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        iPersonaRepo.save(persona);
    }

    @Override
    public Persona findPersona(Long Id) {
        Persona persona = iPersonaRepo.findById(Id).orElse(null);
        return persona;
    }
    
}

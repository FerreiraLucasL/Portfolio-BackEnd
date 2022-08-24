
package com.portfolio.backend.interfaces;

import com.portfolio.backend.entity.Persona;
import java.util.List;

public interface IPersonaServ {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public Persona findPersona(Long Id);
    
}

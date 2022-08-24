
package com.portfolio.backend.interfaces;

import com.portfolio.backend.entity.Experiencia;
import java.util.List;


public interface IExperienciaServ {
    
public List<Experiencia> getExperiencia();
public void saveExperiencia (Experiencia exp);
public void deleteExperiencia(Long id);
public Experiencia findExperiencia(Long id);
}

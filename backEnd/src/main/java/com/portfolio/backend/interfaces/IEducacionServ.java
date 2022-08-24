
package com.portfolio.backend.interfaces;

import com.portfolio.backend.entity.Educacion;
import java.util.List;


public interface IEducacionServ {
    public List<Educacion> getEducacion();
    public void saveEducacion (Educacion exp);
    public void deleteEducacion(Long id);
    public Educacion findEducacion(Long id);
}

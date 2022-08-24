
package com.portfolio.backend.security.service;

import com.portfolio.backend.security.entity.Rol;
import com.portfolio.backend.security.enums.RolNombre;
import com.portfolio.backend.security.repository.iRolRepo;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired iRolRepo irolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepo.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepo.save(rol);
    }
    
}

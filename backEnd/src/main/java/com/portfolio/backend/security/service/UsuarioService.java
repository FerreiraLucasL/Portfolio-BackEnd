
package com.portfolio.backend.security.service;

import com.portfolio.backend.security.entity.Usuario;
import com.portfolio.backend.security.repository.iUsuarioRepo;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired iUsuarioRepo iusuarioRepo;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepo.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepo.save(usuario);
    }
}

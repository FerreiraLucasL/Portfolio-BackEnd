
package com.portfolio.backend.repository;

import com.portfolio.backend.entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IExperienciaRepo extends JpaRepository<Experiencia, Long>{
    
}

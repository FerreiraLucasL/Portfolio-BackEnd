
package com.portfolio.backend.repository;

import com.portfolio.backend.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepo extends JpaRepository<Educacion, Long>{    
    
}

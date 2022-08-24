
package com.portfolio.backend.repository;

import com.portfolio.backend.entity.HardSoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHardSoftSkillRepo extends JpaRepository<HardSoftSkill, Long>{
    
}


package com.portfolio.backend.service;

import com.portfolio.backend.entity.HardSoftSkill;
import com.portfolio.backend.interfaces.IHardSoftSkillServ;
import com.portfolio.backend.repository.IHardSoftSkillRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpHardSoftSkillServ implements IHardSoftSkillServ{
    @Autowired IHardSoftSkillRepo ihardSoftSkillRepo;
    
    @Override
    public List<HardSoftSkill> getHardSoftSkill() {
        List<HardSoftSkill> hardSoftSkill = ihardSoftSkillRepo.findAll();
        return hardSoftSkill;
    }

    @Override
    public void saveHardSoftSkill(HardSoftSkill hardSoftSkill) {
        ihardSoftSkillRepo.save(hardSoftSkill);
    }

    @Override
    public void deleteHardSoftSkill(Long id) {
        ihardSoftSkillRepo.deleteById(id);
    }

    @Override
    public HardSoftSkill findHardSoftSkill(Long id) {
        HardSoftSkill hardSoftSkill = ihardSoftSkillRepo.findById(id).orElse(null);
        return hardSoftSkill;
    }
    
}

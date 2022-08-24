package com.portfolio.backend.interfaces;

import com.portfolio.backend.entity.HardSoftSkill;
import java.util.List;


public interface IHardSoftSkillServ {
    public List<HardSoftSkill> getHardSoftSkill();
    
    public void saveHardSoftSkill(HardSoftSkill hardSoftSkill);
    
    public void deleteHardSoftSkill(Long id);
    
    public HardSoftSkill findHardSoftSkill(Long id);
}

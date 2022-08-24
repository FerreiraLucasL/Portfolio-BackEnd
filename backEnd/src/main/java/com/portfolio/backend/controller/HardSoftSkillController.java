
package com.portfolio.backend.controller;

import com.portfolio.backend.entity.HardSoftSkill;
import com.portfolio.backend.interfaces.IHardSoftSkillServ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HardSoftSkillController {
    @Autowired IHardSoftSkillServ ihardSoftSkillServ;
    
    @GetMapping("/hardsoftskill/get")
    public List<HardSoftSkill> getHardSoftSkill(){
        return ihardSoftSkillServ.getHardSoftSkill();
    }
    
    @PostMapping("/hardsoftskill/create")
    public String createHardSoftSkill(@RequestBody HardSoftSkill hardSoftSkill){
        ihardSoftSkillServ.saveHardSoftSkill(hardSoftSkill);
        return "creada con éxito";
    }
    
    @DeleteMapping("/hardsoftskill/{id}")
    public String deleteHardSoftSkill(@PathVariable Long id){
        ihardSoftSkillServ.deleteHardSoftSkill(id);
        return "borrado con éxito";
    }
    
    @PutMapping("/hardsoftskill/edit/{id}")
    public HardSoftSkill editHardSoftSkill(@PathVariable Long id,
                                           @RequestParam("nombreSkill")String nomSkill,
                                           @RequestParam("valorSkill")Integer valSkill){
        HardSoftSkill hardSoftSkill = ihardSoftSkillServ.findHardSoftSkill(id);
        hardSoftSkill.setNombreSkill(nomSkill);
        hardSoftSkill.setValorSkill(valSkill);
        
        ihardSoftSkillServ.saveHardSoftSkill(hardSoftSkill);
        return hardSoftSkill;
        
    }
    
}

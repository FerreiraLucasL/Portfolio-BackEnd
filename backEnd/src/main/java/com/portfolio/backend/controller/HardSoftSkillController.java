
package com.portfolio.backend.controller;

import com.portfolio.backend.entity.HardSoftSkill;
import com.portfolio.backend.interfaces.IHardSoftSkillServ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<List<HardSoftSkill>> getHardSoftSkill(){
        List<HardSoftSkill> skills=ihardSoftSkillServ.getHardSoftSkill();
        return new ResponseEntity<>(skills, HttpStatus.OK);    
    }    
    
    
    @PostMapping("/hardsoftskill/create")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<HardSoftSkill> createHardSoftSkill(@RequestBody HardSoftSkill hardSoftSkill){
        ihardSoftSkillServ.saveHardSoftSkill(hardSoftSkill);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("/hardsoftskill/{id}")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public String deleteHardSoftSkill(@PathVariable Long id){
        ihardSoftSkillServ.deleteHardSoftSkill(id);
        return "borrado con éxito";
    }
    
    @PutMapping("/hardsoftskill/edit/{id}")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<HardSoftSkill> editHardSoftSkill(@PathVariable Long id,
                                           @RequestParam("nombreSkill")String nomSkill,
                                           @RequestParam("valorSkill")Integer valSkill,
                                           @RequestParam("imgSkill")String valImgSkill){
        HardSoftSkill hardSoftSkill = ihardSoftSkillServ.findHardSoftSkill(id);
        hardSoftSkill.setNombreSkill(nomSkill);
        hardSoftSkill.setValorSkill(valSkill);
        hardSoftSkill.setImgSkill(valImgSkill);
        
        ihardSoftSkillServ.saveHardSoftSkill(hardSoftSkill);
        return new ResponseEntity(hardSoftSkill,HttpStatus.OK);
        
    }    
}

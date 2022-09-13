
package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.interfaces.IExperienciaServ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExperienciaController {
    @Autowired IExperienciaServ iexperienciaServ;
    
    @GetMapping("/experiencia/get")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Experiencia> getExperiencia(){
        return iexperienciaServ.getExperiencia();
    }
    
    @PostMapping("/experiencia/create")
    public String createExperiencia(@RequestBody Experiencia exp){
        iexperienciaServ.saveExperiencia(exp);
        return "creado correctamente";
    }
    
    @DeleteMapping("/experiencia/delete")
    public String deleteExperiencia(@PathVariable Long id){
        iexperienciaServ.deleteExperiencia(id);
        return "borrado correctamente";
    }
    
    @PutMapping ("/experiencia/edit/{id}")
    public Experiencia editExperiencia(@PathVariable Long id,
                                           @RequestParam("experienciaNombre")String expNom,
                                           @RequestParam("experienciaLugar")String expLug,
                                           @RequestParam("experienciaTiempo")String expTie,
                                           @RequestParam("experienciaAños")String expAños){
        Experiencia exp = iexperienciaServ.findExperiencia(id);
        
        exp.setExperienciaNombre(expNom);
        exp.setExperienciaLugar(expLug);
        exp.setExperienciaTiempo(expTie);
        exp.setExperienciaAños(expAños);
        
        iexperienciaServ.saveExperiencia(exp);
        return exp;
    } 
}

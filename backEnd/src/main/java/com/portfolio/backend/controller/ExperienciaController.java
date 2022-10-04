
package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Experiencia;
import com.portfolio.backend.interfaces.IExperienciaServ;
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
public class ExperienciaController {
    @Autowired IExperienciaServ iexperienciaServ;
    
    @GetMapping("/experiencia/get")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app/") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<List<Experiencia>> getExperiencia(){
        List<Experiencia> experiencias=iexperienciaServ.getExperiencia();
        return new ResponseEntity<>(experiencias, HttpStatus.OK);    
    }
    
    
    @PostMapping("/experiencia/create")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app/") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<Experiencia> createExperiencia(@RequestBody Experiencia exp){
        iexperienciaServ.saveExperiencia(exp);
        return new ResponseEntity<>(exp, HttpStatus.OK);
    }
    
    @DeleteMapping("/experiencia/delete")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app/") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public String deleteExperiencia(@PathVariable Long id){
        iexperienciaServ.deleteExperiencia(id);
        return "borrado correctamente";
    }
    
    @PutMapping ("/experiencia/edit/{id}")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app/") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<Experiencia> editExperiencia(@PathVariable Long id,
                                           @RequestParam("experienciaNombre")String expNom,
                                           @RequestParam("experienciaLugar")String expLug,
                                           @RequestParam("experienciaTiempo")String expTie,
                                           @RequestParam("experienciaAnios")String expAnios){
        Experiencia exp = iexperienciaServ.findExperiencia(id);
        
        exp.setExperienciaNombre(expNom);
        exp.setExperienciaLugar(expLug);
        exp.setExperienciaTiempo(expTie);
        exp.setExperienciaAnios(expAnios);
        
        iexperienciaServ.saveExperiencia(exp);
        return new ResponseEntity(HttpStatus.OK);
    } 
}

package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Educacion;
import com.portfolio.backend.interfaces.IEducacionServ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpStatus;

@RestController
public class EducacionController {
    @Autowired IEducacionServ ieducacionServ;
    
    @GetMapping("/educacion/get")    
    @CrossOrigin(origins = "http://localhost:4200")    
    public ResponseEntity<List<Educacion>> getEducacion(){
        List<Educacion> educaciones=ieducacionServ.getEducacion();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);    
    }
    
    @PostMapping("/educacion/create")
    public String createEducacion(@RequestBody Educacion edu){
        ieducacionServ.saveEducacion(edu);
        return "creado con exito";
    }
    
    @DeleteMapping("/educacion/delete")
    public String deleteEducacion(@PathVariable Long id){
        ieducacionServ.deleteEducacion(id);
        return "borrado con éxito";
    }
    
    @PutMapping ("/educacion/edit/{id}")
    public Educacion editEducacion(@PathVariable Long id,
                                           @RequestParam("educacionNombre")String eduNom,
                                           @RequestParam("educacionLugar")String eduLug,
                                           @RequestParam("educacionTiempo")String eduTie,
                                           @RequestParam("educacionAnios")String eduAnios){
        Educacion edu = ieducacionServ.findEducacion(id);
        
        edu.setEducacionNombre(eduNom);
        edu.setEducacionLugar(eduLug);
        edu.setEducacionTiempo(eduTie);
        edu.setEducacionAnios(eduAnios);
        
        ieducacionServ.saveEducacion(edu);
        return edu;
    } 
    
}

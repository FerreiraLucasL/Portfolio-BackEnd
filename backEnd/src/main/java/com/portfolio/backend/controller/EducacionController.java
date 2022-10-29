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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class EducacionController {
    @Autowired IEducacionServ ieducacionServ;
    
    @GetMapping("/educacion/get")    
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200")    
    public ResponseEntity<List<Educacion>> getEducacion(){
        List<Educacion> educaciones=ieducacionServ.getEducacion();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);    
    }
    
    @PostMapping("/educacion/create")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<Educacion> createEducacion(@RequestBody Educacion edu){
        ieducacionServ.saveEducacion(edu);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @DeleteMapping("/educacion/delete/{id}")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<?> deleteEducacion(@PathVariable("id") Long id){
        ieducacionServ.deleteEducacion(id);  
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping ("/educacion/edit/")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<Educacion> editEducacion(@RequestBody Educacion nuevaEdu){
        Educacion edu = ieducacionServ.findEducacion(nuevaEdu.getId());
        
        edu.setEducacionNombre(nuevaEdu.getEducacionNombre());
        edu.setEducacionLugar(nuevaEdu.getEducacionLugar());
        edu.setEducacionTiempo(nuevaEdu.getEducacionTiempo());
        edu.setEducacionAnios(nuevaEdu.getEducacionAnios());        
        ieducacionServ.saveEducacion(edu);
        return new ResponseEntity(edu,HttpStatus.OK);
    } 
    
}


package com.portfolio.backend.controller;

import com.portfolio.backend.entity.Persona;
import com.portfolio.backend.interfaces.IPersonaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaServ iPersonaServ;
    
    @GetMapping("/persona/get/{id}")
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<Persona> getPersona (@PathVariable("id")Long id){
        Persona persona = iPersonaServ.findPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }   
    
    
      
    @PutMapping("/persona/edit/")    
    @CrossOrigin(origins = "https://portfoliolucasferreira.web.app") 
    //@CrossOrigin(origins = "http://localhost:4200") 
    public ResponseEntity<Persona> editPersona(@RequestBody Persona pers){
        Persona persona = iPersonaServ.findPersona(pers.getId());
        
        persona.setNombreApellido(pers.getNombreApellido());
        persona.setCargo(pers.getCargo());
        persona.setLugarNacimiento(pers.getLugarNacimiento());
        persona.setFechaNacimiento(pers.getFechaNacimiento());
        persona.setImg(pers.getImg());
        persona.setBanner(pers.getBanner());
        persona.setAcerca(pers.getAcerca());
        
        iPersonaServ.savePersona(persona);

        return new ResponseEntity<>(persona,HttpStatus.OK);
    }
}


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaServ iPersonaServ;
    
    @GetMapping("/persona/get/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Persona> getPersona (@PathVariable("id")Long id){
        Persona persona = iPersonaServ.findPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
    
    
    /* @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persona/create")
    public String createPersona(@RequestBody Persona persona){
        iPersonaServ.savePersona(persona);
        return "persona creada con exito";
    }       */
    
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/edit/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombreApellido") String nuevoNombreApellido,
                                @RequestParam("cargo") String nuevoCargo,
                                @RequestParam("lugarNacimiento") String nuevoLugarNac,
                                @RequestParam("fechaNacimiento") String nuevoFechaNac,
                                @RequestParam("img")String nuevoImg,
                                @RequestParam("acerca")String nuevoAcerca){
        Persona persona = iPersonaServ.findPersona(id);
        
        persona.setNombreApellido(nuevoNombreApellido);
        persona.setCargo(nuevoCargo);
        persona.setLugarNacimiento(nuevoLugarNac);
        persona.setFechaNacimiento(nuevoFechaNac);
        persona.setImg(nuevoImg);
        
        iPersonaServ.savePersona(persona);
        return persona;
        
    }
        
    
    
}

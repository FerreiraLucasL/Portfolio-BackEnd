
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
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Persona> editPersona(@PathVariable Long id,
                                                @RequestParam("nombreApellido") String nuevoNomApe,
                                                @RequestParam("cargo")String nuevoCargo,
                                                @RequestParam("lugarNacimiento")String nuevoLugar,
                                                @RequestParam("fechaNacimiento")String nuevoFechaNac,
                                                @RequestParam("img")String nuevoImg,
                                                @RequestParam("banner")String nuevoBanner){
        Persona persona = iPersonaServ.findPersona(id);
        
        persona.setNombreApellido(nuevoNomApe);
        persona.setCargo(nuevoCargo);
        persona.setLugarNacimiento(nuevoBanner);
        persona.setFechaNacimiento(nuevoFechaNac);
        persona.setImg(nuevoImg);
        persona.setBanner(nuevoBanner);
        
        return new ResponseEntity<>(persona,HttpStatus.OK);
    }
}

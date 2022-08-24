package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombreApellido;
    private String cargo;
    private String lugarNacimiento;
    private String fechaNacimiento;
    private String img;

    public Persona() {
    }    
    
    public Persona(String nombreApellido, String Cargo, String lugarNacimiento, String fechaNacimiento, String img) {
        this.nombreApellido = nombreApellido;
        this.cargo = Cargo;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.img = img;
    }
    
    
}

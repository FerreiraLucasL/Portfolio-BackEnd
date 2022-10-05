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
    private String acerca;
    private String banner;

    public Persona() {
    }    
    
    public Persona(String nombreApellido, String cargo, String lugarNacimiento, String fechaNacimiento, String img, String acerca, String banner) {
        this.nombreApellido = nombreApellido;
        this.cargo = cargo;
        this.lugarNacimiento = lugarNacimiento;
        this.fechaNacimiento = fechaNacimiento;
        this.img = img;
        this.acerca = acerca;
        this.banner = banner;
    }    
}

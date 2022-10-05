
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
public class Educacion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)   
    private Long Id;
    @NotNull
    private String educacionNombre;    
    private String educacionLugar;
    private String educacionTiempo;
    private String educacionAnios;

    public Educacion() {
    }

    public Educacion(String educacionNombre, String educacionLugar, String educacionTiempo, String educacionAnios) {
        this.educacionNombre = educacionNombre;
        this.educacionLugar = educacionLugar;
        this.educacionTiempo = educacionTiempo;
        this.educacionAnios = educacionAnios;
    }
    
    
}

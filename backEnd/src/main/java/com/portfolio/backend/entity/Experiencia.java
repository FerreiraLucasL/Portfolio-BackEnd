
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
public class Experiencia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)   
    private Long id;
    @NotNull
    private String experienciaNombre;
    @NotNull
    private String experienciaLugar;
    private String experienciaTiempo;
    private String experienciaAnios;

    public Experiencia() {
    }

    public Experiencia(String experienciaNombre, String experienciaLugar, String experienciaTiempo, String experienciaAnios) {
        this.experienciaNombre = experienciaNombre;
        this.experienciaLugar = experienciaLugar;
        this.experienciaTiempo = experienciaTiempo;
        this.experienciaAnios = experienciaAnios;
    }
    
}

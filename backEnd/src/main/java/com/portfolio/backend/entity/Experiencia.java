
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
    private Long Id;
    @NotNull
    private String experienciaNombre;
    @NotNull
    private String experienciaLugar;
    @NotNull
    private String experienciaTiempo;
    @NotNull
    private String experienciaAnios;
    
    
    
}

package com.portfolio.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class HardSoftSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombreSkill;
    @NotNull
    private int valorSkill;
    private String imgSkill;

    public HardSoftSkill() {
    }

    public HardSoftSkill(String nombreSkill, int valorSkill, String imgSkill) {
        this.nombreSkill = nombreSkill;
        this.valorSkill = valorSkill;
        this.imgSkill = imgSkill;
    }
 
    
}

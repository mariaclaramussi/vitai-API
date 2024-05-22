package com.example.vitai.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("medico")
public class Medico extends Pessoa{
    
}

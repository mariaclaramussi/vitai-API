package com.example.vitai.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("atendente")
public class Atendente extends Pessoa {
    
}

package com.example.vitai.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("paciente")
public class Paciente extends Pessoa{

}

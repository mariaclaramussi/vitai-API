package com.example.vitai.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("paciente")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente extends Pessoa {

    @JoinColumn(name = "numero_pulseira")
    private int numeroPulseira;
}

package com.example.vitai.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("medico")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medico extends Pessoa {

    private String CRM;
}

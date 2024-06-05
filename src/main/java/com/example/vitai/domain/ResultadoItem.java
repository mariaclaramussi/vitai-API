package com.example.vitai.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resultado_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor 
public class ResultadoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String valor;

    private String mnemonico;

    @ManyToOne
    @JoinColumn(name = "resultado_id", nullable = false)
    private Resultado codResultado;

    @Version
    private LocalDateTime timTimestamp;
}

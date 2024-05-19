package com.example.vitai.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categoria_exame")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExameCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String nome;
    
    @Column (nullable = false)
    private String tipo;
    
    // Muitas categorias para uma secao
    @ManyToOne
    @JoinColumn (name = "secao_id", nullable = false)
    private Secao secao;
    
    // Muitas categorias para uma modalidade
    @ManyToOne
    @JoinColumn (name = "modalidade_id", nullable = false)
    private Modalidade modalidade;
    
    private String descricao;
}

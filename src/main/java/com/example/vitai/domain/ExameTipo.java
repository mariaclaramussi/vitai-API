package com.example.vitai.domain;

import java.time.LocalDateTime;

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
@Table(name = "exame_tipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExameTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String nome;

    @Column(name = "prazo_execucao")
    private int prazoExecucao;

    @ManyToOne
    @JoinColumn(name = "categoria_exame_id")
    private ExameCategoria codCategoria;

    private String mnemonico;

    @Column(name = "tipo_exame")
    private String tipoExame;

    @Column(name = "intervalo_pedidos")
    private int intervaloPedidos;

    @Column(name = "exige_laudo")
    private boolean exigeLaudo;

    @Column(name = "necessita_preparo")
    private boolean necessitaPreparo;

    private LocalDateTime timTimestamp;

    @Column(name = "data_exclusao")
    private LocalDateTime dataExclusao;
}

package com.example.vitai.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status; // pendente, liberado, realizado

    @Column(name = "data_realizacao")
    private LocalDateTime dataRealizacao;

    @Column(name = "data_coleta")
    private LocalDateTime dataColeta;

    @Column(name = "data_liberacao")
    private LocalDateTime dataLiberacao;

    @Column(name = "data_exclusao")
    private LocalDateTime dataExclusao;

    @Column(name = "data_aguardando_laudo")
    private LocalDateTime dataAguardandoLaudo;

    @Column(name = "indicacao_clinica")
    private String indicacaoClinica;

    @Column(name = "motivo_exclusao")
    private String motivoExclusao;

    @ManyToOne
    @JoinColumn(name = "exame_tipo_id", nullable = false)
    private ExameTipo codExameTipo;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonBackReference
    private Pedido codPedido;

    @OneToMany(mappedBy = "codPedidoItem")
    private List<Resultado> resultado;

    @Version
    private LocalDateTime timTimestamp;
}

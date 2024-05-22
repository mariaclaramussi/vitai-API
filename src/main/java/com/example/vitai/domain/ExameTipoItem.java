package com.example.vitai.domain;

import java.time.LocalDateTime;
import java.util.List;

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
@Table(name = "exame_tipo_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExameTipoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String nome;

    private String mnemonico;

    @Column (nullable = false)
    private String unidade;

    @ManyToOne
    @JoinColumn (name = "exame_tipo_id", nullable = false)
    private ExameTipo codExameTipo;

    @Column(name = "valor_referencia")
    private String valorReferencia;

    // SubExameTipo = Dominio do item = Grupo
    // varios ExameTipoItem pertencem a um SubExameTipo
    @OneToMany
    @JoinColumn (name = "sub_exame_tipo_id", nullable = false)
    private List<SubExameTipo> codSubExameTipo;

    @Version
    private LocalDateTime timTimestamp;

}

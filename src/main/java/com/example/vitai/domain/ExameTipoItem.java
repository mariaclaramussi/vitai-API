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

    //classe material
    // varios ExameTipoItem pertencem ao mesmo Material
    // NAO DEVERIA FAZER PARTE DE EXAMETIPO?
    // private Material codTipoMaterial;

    // varios ExameTipoItem pertencem a um método
    // NAO DEVERIA FAZER PARTE DE EXAMETIPO?
    @ManyToOne
    @JoinColumn (name = "metodo_id", nullable = false)
    private Metodo codTipoMetodo;

    // SubExameTipo = Dominio do item = Grupo
    // varios ExameTipoItem pertencem a um SubExameTipo
    @ManyToOne
    @JoinColumn (name = "sub_exame_tipo_id", nullable = false)
    private SubExameTipo codSubExameTipo;

    private LocalDateTime timTimestamp;

}

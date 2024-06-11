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
@Table(name = "sub_exame_tipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubExameTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (nullable = false)
    private String nome;

    private String descricao;

    @Version
    private LocalDateTime timTimestamp;

    @ManyToOne
    @JoinColumn (name = "exame_tipo_id", nullable = false)
    @JsonBackReference
    private ExameTipo exameTipo;

    @OneToMany(mappedBy = "codSubExameTipo")
    private List<ExameTipoItem> exameTipoItems;
}

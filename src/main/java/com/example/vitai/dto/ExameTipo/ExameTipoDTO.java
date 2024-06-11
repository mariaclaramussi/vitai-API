package com.example.vitai.dto.ExameTipo;

import java.time.LocalDateTime;
import java.util.List;

import com.example.vitai.domain.ExameCategoria;
import com.example.vitai.domain.Material;
import com.example.vitai.domain.Metodo;
import com.example.vitai.domain.SubExameTipo;

public record ExameTipoDTO(
    Integer id,
    String nome,
    Integer prazoExecucao,
    ExameCategoria codCategoria,
    String mnemonico,
    Integer intervaloPedidos,
    Boolean exigeLaudo,
    Boolean necessitaPreparo,
    LocalDateTime dataExclusao,
    Material codTipoMaterial,
    Metodo codTipoMetodo,
    List<SubExameTipo> subExamesTipoList
) {

}

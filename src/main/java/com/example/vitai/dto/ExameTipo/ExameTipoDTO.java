package com.example.vitai.dto.ExameTipo;

import java.time.LocalDateTime;

import com.example.vitai.domain.ExameCategoria;
import com.example.vitai.domain.Material;
import com.example.vitai.domain.Metodo;

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
    Metodo codTipoMetodo
) {

}

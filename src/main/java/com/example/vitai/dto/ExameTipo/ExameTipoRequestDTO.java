package com.example.vitai.dto.ExameTipo;

import java.time.LocalDateTime;

public record ExameTipoRequestDTO(
    Integer id,
    String nome,
    Integer prazoExecucao,
    Integer codCategoria,
    String mnemonico,
    Integer intervaloPedidos,
    Boolean exigeLaudo,
    Boolean necessitaPreparo,
    LocalDateTime dataExclusao,
    Integer codTipoMaterial,
    Integer codTipoMetodo
) {

}

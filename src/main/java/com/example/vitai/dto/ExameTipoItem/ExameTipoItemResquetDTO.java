package com.example.vitai.dto.ExameTipoItem;

public record ExameTipoItemResquetDTO(
    Integer id,
    String nome,
    String unidade,
    String mnemonico,
    Integer codExameTipo,
    String valorReferencia,
    Integer codSubExameTipo
) {

}

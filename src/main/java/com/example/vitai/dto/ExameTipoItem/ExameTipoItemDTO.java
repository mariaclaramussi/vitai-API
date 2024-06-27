package com.example.vitai.dto.ExameTipoItem;

public record ExameTipoItemDTO(
                Integer id,
                String nome,
                String mnemonico,
                String unidade,
                Integer codExameTipo,
                String valorReferencia,
                Integer subExameTipoId) {

}

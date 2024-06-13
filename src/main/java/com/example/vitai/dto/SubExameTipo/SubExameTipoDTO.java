package com.example.vitai.dto.SubExameTipo;

import java.util.List;

import com.example.vitai.domain.ExameTipo;
import com.example.vitai.domain.ExameTipoItem;

public record SubExameTipoDTO(
    String nome,
    String descricao,
    ExameTipo exameTipo,
    List<ExameTipoItem> exameTipoItemsList
) {

}

package com.example.vitai.dto.SubExameTipo;

import java.util.List;

import com.example.vitai.domain.ExameTipoItem;


public record SubExameTipoRequestDTO(
    String nome,
    String descricao,
    Integer codExameTipo, 
    List<ExameTipoItem> exameTipoItems
) {
    
}

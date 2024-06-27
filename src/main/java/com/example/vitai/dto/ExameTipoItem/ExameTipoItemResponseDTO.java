package com.example.vitai.dto.ExameTipoItem;

import com.example.vitai.domain.ExameTipoItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExameTipoItemResponseDTO {
    ExameTipoItemDTO exameTipoItem;

    public ExameTipoItemResponseDTO(ExameTipoItem exameTipoItem) {
        this.exameTipoItem = new ExameTipoItemDTO(exameTipoItem.getId(), exameTipoItem.getNome(),
                exameTipoItem.getMnemonico(),
                exameTipoItem.getUnidade(), exameTipoItem.getCodExameTipo().getId(), exameTipoItem.getValorReferencia(),
                exameTipoItem.getSubExameTipo().getId());
    }
}

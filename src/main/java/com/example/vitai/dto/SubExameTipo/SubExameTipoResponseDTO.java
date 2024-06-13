package com.example.vitai.dto.SubExameTipo;

import com.example.vitai.domain.SubExameTipo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubExameTipoResponseDTO {
    SubExameTipoDTO subExameTipo;

    public SubExameTipoResponseDTO(SubExameTipo subExameTipo) {
        this.subExameTipo = new SubExameTipoDTO(subExameTipo.getNome(), subExameTipo.getDescricao(),
                subExameTipo.getExameTipo(), subExameTipo.getExameTipoItemsList());
    }
}
    
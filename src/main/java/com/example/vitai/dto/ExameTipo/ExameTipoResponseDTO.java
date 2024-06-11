package com.example.vitai.dto.ExameTipo;

import com.example.vitai.domain.ExameTipo;

public class ExameTipoResponseDTO {

    ExameTipoDTO exameTipo;

    public ExameTipoResponseDTO(ExameTipo exameTipo) {
        this.exameTipo = new ExameTipoDTO(exameTipo.getId(), exameTipo.getNome(), exameTipo.getPrazoExecucao(),
                exameTipo.getCodCategoria(), exameTipo.getMnemonico(), exameTipo.getIntervaloPedidos(),
                exameTipo.isExigeLaudo(), exameTipo.isNecessitaPreparo(), exameTipo.getDataExclusao(),
                exameTipo.getCodTipoMaterial(), exameTipo.getCodTipoMetodo());
    }
}

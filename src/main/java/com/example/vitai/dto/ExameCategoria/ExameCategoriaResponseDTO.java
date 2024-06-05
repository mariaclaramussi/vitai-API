package com.example.vitai.dto.ExameCategoria;

import com.example.vitai.domain.ExameCategoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExameCategoriaResponseDTO {
    ExameCategoriaDTO categoria;

    public ExameCategoriaResponseDTO(ExameCategoria categoria) {
        this.categoria = new ExameCategoriaDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao(), categoria.getTipoCategoria(), categoria.getSecao(), categoria.getModalidade());
    }
}

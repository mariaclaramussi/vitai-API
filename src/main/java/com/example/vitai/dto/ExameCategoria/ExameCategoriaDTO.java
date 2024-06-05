package com.example.vitai.dto.ExameCategoria;

import com.example.vitai.domain.Modalidade;
import com.example.vitai.domain.Secao;

public record ExameCategoriaDTO(
    Integer id,
    String nome,
    String descricao,
    String tipo_categoria,
    Secao secao,
    Modalidade modalidade
) {

}

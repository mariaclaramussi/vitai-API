package com.example.vitai.dto.ExameCategoria;

public record ExameCategoriaRequestDTO(
        Integer id,
        String nome,
        String descricao,
        String tipoCategoria,
        Integer codSecao,
        Integer codModalidade) {
}

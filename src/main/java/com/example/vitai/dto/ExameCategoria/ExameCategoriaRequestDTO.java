package com.example.vitai.dto.ExameCategoria;

public record ExameCategoriaRequestDTO(    
    Integer id, 
    String nome,
    String descricao,
    String tipoCategoria,
    String secao,
    String modalidade) {
}

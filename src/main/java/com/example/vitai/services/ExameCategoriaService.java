package com.example.vitai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.ExameCategoria;
import com.example.vitai.domain.Modalidade;
import com.example.vitai.domain.Secao;
import com.example.vitai.dto.ExameCategoria.ExameCategoriaIdDTO;
import com.example.vitai.dto.ExameCategoria.ExameCategoriaRequestDTO;
import com.example.vitai.dto.ExameCategoria.ExameCategoriaResponseDTO;
import com.example.vitai.repository.ExameCategoriaRepository;
import com.example.vitai.repository.ModalidadeRepository;
import com.example.vitai.repository.SecaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExameCategoriaService {
    private final ExameCategoriaRepository exameCategoriaRepository;
    private final ModalidadeRepository modalidadeRepository;
    private final SecaoRepository secaoRepository;

    public List<ExameCategoria> getCategorias() {
        return exameCategoriaRepository.findAll();
    }

    public ExameCategoriaIdDTO createCategoriaExame(ExameCategoriaRequestDTO categoriaDTO) {
        ExameCategoria newCategoria = new ExameCategoria();

        newCategoria.setNome(categoriaDTO.nome());
        newCategoria.setDescricao(categoriaDTO.descricao());
        newCategoria.setTipoCategoria(categoriaDTO.tipoCategoria());

        Modalidade modalidade = modalidadeRepository.findById(categoriaDTO.codModalidade()).get();
        newCategoria.setModalidade(modalidade);

        Secao secao = secaoRepository.findById(categoriaDTO.codSecao()).get();
        newCategoria.setSecao(secao);

        this.exameCategoriaRepository.save(newCategoria);

        return new ExameCategoriaIdDTO(newCategoria.getId());
    }

    public ExameCategoriaResponseDTO getCategoriaById(String id) {
        ExameCategoria categoria = this.exameCategoriaRepository.findById(Integer.parseInt(id)).get();

        return new ExameCategoriaResponseDTO(categoria);
    }
}

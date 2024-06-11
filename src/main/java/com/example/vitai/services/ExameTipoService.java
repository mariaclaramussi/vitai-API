package com.example.vitai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.ExameCategoria;
import com.example.vitai.domain.ExameTipo;
import com.example.vitai.domain.Material;
import com.example.vitai.domain.Metodo;
import com.example.vitai.dto.ExameTipo.ExameTipoIdDTO;
import com.example.vitai.dto.ExameTipo.ExameTipoRequestDTO;
import com.example.vitai.dto.ExameTipo.ExameTipoResponseDTO;
import com.example.vitai.repository.ExameCategoriaRepository;
import com.example.vitai.repository.ExameTipoRepository;
import com.example.vitai.repository.MaterialRepository;
import com.example.vitai.repository.MetodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExameTipoService {
    private final ExameTipoRepository exameTipoRepository;
    private final ExameCategoriaRepository exameCategoriaRepository;
    private final MaterialRepository materialRepository;
    private final MetodoRepository metodoRepository;

    public List<ExameTipo> getExames() {
        return exameTipoRepository.findAll();
    }

    public ExameTipoIdDTO createExameTipo(ExameTipoRequestDTO exameTipoDTO) {
        ExameTipo newExameTipo = new ExameTipo();

        newExameTipo.setNome(exameTipoDTO.nome());
        newExameTipo.setPrazoExecucao(exameTipoDTO.prazoExecucao());
        newExameTipo.setMnemonico(exameTipoDTO.mnemonico());
        newExameTipo.setIntervaloPedidos(exameTipoDTO.intervaloPedidos());
        newExameTipo.setExigeLaudo(exameTipoDTO.exigeLaudo());
        newExameTipo.setNecessitaPreparo(exameTipoDTO.necessitaPreparo());
        newExameTipo.setDataExclusao(exameTipoDTO.dataExclusao());

        ExameCategoria categoria = exameCategoriaRepository.findById(exameTipoDTO.codCategoria()).get();
        newExameTipo.setCodCategoria(categoria);

        Material material = materialRepository.findById(exameTipoDTO.codTipoMaterial()).get();
        newExameTipo.setCodTipoMaterial(material);

        Metodo metodo = metodoRepository.findById(exameTipoDTO.codTipoMetodo()).get();
        newExameTipo.setCodTipoMetodo(metodo);

        this.exameTipoRepository.save(newExameTipo);

        return new ExameTipoIdDTO(newExameTipo.getId());
    }

    public ExameTipoResponseDTO getExameTipoById(String id) {
        ExameTipo exameTipo = this.exameTipoRepository.findById(Integer.parseInt(id)).get();

        return new ExameTipoResponseDTO(exameTipo);
    }
}

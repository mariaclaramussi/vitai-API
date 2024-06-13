package com.example.vitai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.ExameTipo;
import com.example.vitai.domain.ExameTipoItem;
import com.example.vitai.domain.SubExameTipo;
import com.example.vitai.dto.SubExameTipo.SubExameTipoIdDTO;
import com.example.vitai.dto.SubExameTipo.SubExameTipoRequestDTO;
import com.example.vitai.repository.ExameTipoItemRepository;
import com.example.vitai.repository.ExameTipoRepository;
import com.example.vitai.repository.SubExameTipoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubExameTipoService {

    private final SubExameTipoRepository subExameTipoRepository;
    private final ExameTipoRepository exameTipoRepository;
    private final ExameTipoItemRepository exameTipoItemRepository;

    public List<SubExameTipo> getSubExameTipos() {
        return subExameTipoRepository.findAll();
    }

    public SubExameTipoIdDTO createSubExameTipo(SubExameTipoRequestDTO subExame) {
        SubExameTipo newSubExame = new SubExameTipo();

        newSubExame.setNome(subExame.nome());
        newSubExame.setDescricao(subExame.descricao());

        Optional<ExameTipo> newExameTipo = exameTipoRepository.findById(subExame.codExameTipo());
        if (newExameTipo.isPresent())
            newSubExame.setExameTipo(newExameTipo.get());
        newExameTipo.get().addSubExameTipo(newSubExame);

        this.subExameTipoRepository.save(newSubExame);

        return new SubExameTipoIdDTO(newSubExame.getId());
    }

    public Optional<List<ExameTipoItem>> getExameItemsBySubExame(String id) {
        return exameTipoItemRepository.findAllBySubExameTipoId(Integer.parseInt(id));
    }
}

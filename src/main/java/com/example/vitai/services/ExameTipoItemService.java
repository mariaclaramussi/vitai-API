package com.example.vitai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.ExameTipo;
import com.example.vitai.domain.ExameTipoItem;
import com.example.vitai.domain.SubExameTipo;
import com.example.vitai.dto.ExameTipoItem.ExameTipoItemIdDTO;
import com.example.vitai.dto.ExameTipoItem.ExameTipoItemResquetDTO;
import com.example.vitai.repository.ExameTipoItemRepository;
import com.example.vitai.repository.ExameTipoRepository;
import com.example.vitai.repository.SubExameTipoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExameTipoItemService {

    private final ExameTipoItemRepository exameTipoItemRepository;
    private final ExameTipoRepository exameTipoRepository;
    private final SubExameTipoRepository subExameTipoRepository;

    public List<ExameTipoItem> getAllExameTipoItems() {
        return exameTipoItemRepository.findAll();
    }

    public ExameTipoItemIdDTO createExameTipoItem(ExameTipoItemResquetDTO exameTipoItem) {
        ExameTipoItem newExameTipoItem = new ExameTipoItem();

        newExameTipoItem.setNome(exameTipoItem.nome());
        newExameTipoItem.setUnidade(exameTipoItem.unidade());
        newExameTipoItem.setValorReferencia(exameTipoItem.valorReferencia());
        newExameTipoItem.setMnemonico(exameTipoItem.mnemonico());

        // ainda nao sei se precisa
        ExameTipo exameTipo = exameTipoRepository.findById(exameTipoItem.codExameTipo()).get();
        newExameTipoItem.setCodExameTipo(exameTipo);

        SubExameTipo subExameTipo = subExameTipoRepository.findById(exameTipoItem.codSubExameTipo()).get();
        subExameTipo.addExameTipoItem(newExameTipoItem);
        
        newExameTipoItem.setSubExameTipo(subExameTipo);

        this.exameTipoItemRepository.save(newExameTipoItem);

        return new ExameTipoItemIdDTO(newExameTipoItem.getId());
    }
}

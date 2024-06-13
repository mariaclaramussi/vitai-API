package com.example.vitai.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vitai.domain.ExameTipoItem;
import com.example.vitai.domain.SubExameTipo;
import com.example.vitai.dto.SubExameTipo.SubExameTipoIdDTO;
import com.example.vitai.dto.SubExameTipo.SubExameTipoRequestDTO;
import com.example.vitai.services.SubExameTipoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/sub-exames")
@RequiredArgsConstructor
public class SubExameTipoController {
    private final SubExameTipoService subExameTipoService;

    @GetMapping("/**")
    public List<SubExameTipo> getAllSubExameTipos() {
        return subExameTipoService.getSubExameTipos();
    }

    @PostMapping
    public ResponseEntity<SubExameTipoIdDTO> createSubExameTipo(@RequestBody SubExameTipoRequestDTO body,
            UriComponentsBuilder uriComponentsBuilder) {
        SubExameTipoIdDTO subExameDTO = subExameTipoService.createSubExameTipo(body);

        var uri = uriComponentsBuilder.path("/sub-exames/{id}").buildAndExpand(subExameDTO.id()).toUri();

        return ResponseEntity.created(uri).body(subExameDTO);
    }

    @GetMapping("/{id}/items")
    public List<ExameTipoItem> getExameItemsBySubExame(@PathVariable String id) {
        Optional<List<ExameTipoItem>> exameItemsBySubExame = subExameTipoService.getExameItemsBySubExame(id);
        if(exameItemsBySubExame.isPresent())
            return exameItemsBySubExame.get();
        return null;
    }
}

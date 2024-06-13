package com.example.vitai.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vitai.domain.ExameTipoItem;
import com.example.vitai.dto.ExameTipoItem.ExameTipoItemIdDTO;
import com.example.vitai.dto.ExameTipoItem.ExameTipoItemResquetDTO;
import com.example.vitai.services.ExameTipoItemService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exame-items")
public class ExameTipoItemController {

    private final ExameTipoItemService exameTipoItemService;

    @GetMapping("/**")
    public List<ExameTipoItem> getAllExameItems() {
        return exameTipoItemService.getAllExameTipoItems();
    }

    @PostMapping
    public ResponseEntity<ExameTipoItemIdDTO> postMethodName(@RequestBody ExameTipoItemResquetDTO body, UriComponentsBuilder uriComponentsBuilder) {
        ExameTipoItemIdDTO exameTipoItemDTO = exameTipoItemService.createExameTipoItem(body);
        
        var uri = uriComponentsBuilder.path("/exame-items/{id}").buildAndExpand(exameTipoItemDTO.id()).toUri();

        return ResponseEntity.created(uri).body(exameTipoItemDTO);
    }
    
}

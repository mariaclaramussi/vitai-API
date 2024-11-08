package com.example.vitai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vitai.domain.ExameTipo;
import com.example.vitai.domain.SubExameTipo;
import com.example.vitai.dto.ExameTipo.ExameTipoIdDTO;
import com.example.vitai.dto.ExameTipo.ExameTipoRequestDTO;
import com.example.vitai.dto.ExameTipo.ExameTipoResponseDTO;
import com.example.vitai.services.ExameTipoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/exames")
@CrossOrigin(origins = "http://localhost:3000")
public class ExameTipoController {
    private final ExameTipoService exameTipoService;

    @GetMapping("/**")
    public List<ExameTipo> getAllExames() {
        return exameTipoService.getExames();
    }

    @PostMapping
    public ResponseEntity<ExameTipoIdDTO> createExameTipo(@RequestBody ExameTipoRequestDTO body,
            UriComponentsBuilder uriComponentsBuilder) {
        ExameTipoIdDTO exameTipoDTO = exameTipoService.createExameTipo(body);

        var uri = uriComponentsBuilder.path("/exames/{id}").buildAndExpand(exameTipoDTO.id()).toUri();

        return ResponseEntity.created(uri).body(exameTipoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameTipoResponseDTO> getExameTipo(@PathVariable String id) {
        ExameTipoResponseDTO exameTipo = this.exameTipoService.getExameTipoById(id);

        return new ResponseEntity<ExameTipoResponseDTO>(exameTipo, exameTipo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/sub-exames")
    public List<SubExameTipo> getSubExamesOfExameTipo(@PathVariable String id) {
        Optional<List<SubExameTipo>> subExamesFromExameTipoList = this.exameTipoService.getSubExamesOfExameTipo(id);
        if (subExamesFromExameTipoList.isPresent())
            return subExamesFromExameTipoList.get();
        return null;
    }
    
}

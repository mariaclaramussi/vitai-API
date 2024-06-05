package com.example.vitai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vitai.domain.ExameCategoria;
import com.example.vitai.dto.ExameCategoria.ExameCategoriaIdDTO;
import com.example.vitai.dto.ExameCategoria.ExameCategoriaRequestDTO;
import com.example.vitai.dto.ExameCategoria.ExameCategoriaResponseDTO;
import com.example.vitai.services.ExameCategoriaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/categorias-de-exame")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor

public class ExameCategoriaController {

    public final ExameCategoriaService exameCategoriaService;

    @GetMapping("/**")
    public List<ExameCategoria> getAllCategorias() {
        return exameCategoriaService.getCategorias();
    }

    @PostMapping
    public ResponseEntity<ExameCategoriaIdDTO> createCategoriaExame(@RequestBody ExameCategoriaRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        ExameCategoriaIdDTO exameCategoriaDTO = exameCategoriaService.createCategoriaExame(body);
        
        System.out.println(body);

        var uri = uriComponentsBuilder.path("/categorias-de-exame/{id}").buildAndExpand(exameCategoriaDTO.id()).toUri();

        return ResponseEntity.created(uri).body(exameCategoriaDTO);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ExameCategoriaResponseDTO> getCategoria(@PathVariable String id) {
        ExameCategoriaResponseDTO categoria = this.exameCategoriaService.getCategoriaById(id);  

        return ResponseEntity.ok(categoria);
    }
}

package com.example.vitai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.vitai.domain.ExameCategoria;
import com.example.vitai.repository.ExameCategoriaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
public class ExameCategoriaController {
    private final ExameCategoriaRepository exameCategoriaRepository;

    @RequestMapping("/categoria-exame")
    public List<ExameCategoria> getAllCategorias() {
        return exameCategoriaRepository.findAll();
    }
}

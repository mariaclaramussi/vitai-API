package com.example.vitai.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.vitai.domain.ExameTipo;
import com.example.vitai.repository.ExameTipoRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExameTipoController {
    private final ExameTipoRepository exameTipoRepository;

    @RequestMapping("/exames")
    public List<ExameTipo> getAllExames() {
        return exameTipoRepository.findAll();
    }
}

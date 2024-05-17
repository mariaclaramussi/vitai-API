package com.example.vitai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitai.domain.Modalidade;
import com.example.vitai.repository.ModalidadeRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ModalidadeController {

    private final ModalidadeRepository modalidadeRepository;

    @RequestMapping(value = "/modalidades")
    public List<Modalidade> getAllModalidades() {
        return modalidadeRepository.findAll();
    }
}

package com.example.vitai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitai.domain.Secao;
import com.example.vitai.repository.SecaoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SecaoController {

    private final SecaoRepository secaoRepository;

    @RequestMapping(value = "/secoes")
    public List<Secao> getAllSecao() {
        return secaoRepository.findAll();
    }
}

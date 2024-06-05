package com.example.vitai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitai.domain.Secao;
import com.example.vitai.repository.SecaoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SecaoController {

    private final SecaoRepository secaoRepository;

    @RequestMapping(value = "/secoes")
    public List<Secao> getAllSecao() {
        return secaoRepository.findAll();
    }
}

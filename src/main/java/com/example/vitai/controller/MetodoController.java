package com.example.vitai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitai.domain.Metodo;
import com.example.vitai.repository.MetodoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MetodoController {
    private final MetodoRepository metodoRepository;

    @RequestMapping("/metodos")
    public List<Metodo> getAllMetodos() {
        return metodoRepository.findAll();
    }
}

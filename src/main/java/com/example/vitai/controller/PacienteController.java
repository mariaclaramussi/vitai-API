package com.example.vitai.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitai.domain.Pessoa;
import com.example.vitai.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PacienteController {
    private final PessoaRepository pessoaRepository;

    @RequestMapping(value = "/pacientes")
    public List<Pessoa> getAllPacientes() {
        return pessoaRepository.findAllByTipo("paciente");
    }

}

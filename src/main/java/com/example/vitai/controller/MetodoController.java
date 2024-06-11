package com.example.vitai.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.vitai.domain.Metodo;
import com.example.vitai.dto.Metodo.MetodoIdDTO;
import com.example.vitai.dto.Metodo.MetodoRequestDTO;
import com.example.vitai.services.MetodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/metodos")
public class MetodoController {
    private final MetodoService metodoService;

    @GetMapping("/**")
    public List<Metodo> getAllMetodos() {
        return metodoService.getMetodos();
    }

    @PostMapping
    public ResponseEntity<MetodoIdDTO> createExameTipo(@RequestBody MetodoRequestDTO body,
            UriComponentsBuilder uriComponentsBuilder) {
        MetodoIdDTO metodoDTO = metodoService.createMetodo(body);

        var uri = uriComponentsBuilder.path("/metodos/{id}").buildAndExpand(metodoDTO.id()).toUri();

        return ResponseEntity.created(uri).body(metodoDTO);
    }
}

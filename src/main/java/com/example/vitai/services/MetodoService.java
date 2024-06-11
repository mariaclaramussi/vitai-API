package com.example.vitai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.Metodo;
import com.example.vitai.dto.Metodo.MetodoIdDTO;
import com.example.vitai.dto.Metodo.MetodoRequestDTO;
import com.example.vitai.repository.MetodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetodoService {
    private final MetodoRepository metodoRepository;

    public List<Metodo> getMetodos() {
        return metodoRepository.findAll();
    }

    public MetodoIdDTO createMetodo(MetodoRequestDTO metodo) {
        Metodo newMetodo = new Metodo();

        newMetodo.setNome(metodo.nome());
        
        this.metodoRepository.save(newMetodo);

        return new MetodoIdDTO(newMetodo.getId());
    }
}

package com.example.vitai.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vitai.domain.Material;
import com.example.vitai.repository.MaterialRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialRepository materialRepository;

    @RequestMapping("/materiais")
    public List<Material> getAllMateriais() {
        return materialRepository.findAll();
    }
}



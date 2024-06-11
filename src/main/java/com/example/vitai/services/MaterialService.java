package com.example.vitai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vitai.domain.Material;
import com.example.vitai.dto.Material.MaterialIdDTO;
import com.example.vitai.dto.Material.MaterialRequestDTO;
import com.example.vitai.repository.MaterialRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepository materialRepository;

    public List<Material> getMateriais() {
        return materialRepository.findAll();
    }

    public MaterialIdDTO createMaterial(MaterialRequestDTO material) {
        Material newMaterial = new Material();

        newMaterial.setNome(material.nome());
        newMaterial.setQtdMaxima(material.qtdMaxima());

        this.materialRepository.save(newMaterial);

        return new MaterialIdDTO(newMaterial.getId());
    }
}

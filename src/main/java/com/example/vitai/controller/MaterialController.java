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

import com.example.vitai.domain.Material;
import com.example.vitai.dto.Material.MaterialIdDTO;
import com.example.vitai.dto.Material.MaterialRequestDTO;
import com.example.vitai.services.MaterialService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/materiais")
public class MaterialController {
    private final MaterialService materialService;

    @GetMapping("/**")
    public List<Material> getAllMateriais() {
        return materialService.getMateriais();
    }

    @PostMapping
    public ResponseEntity<MaterialIdDTO> createExameTipo(@RequestBody MaterialRequestDTO body,
            UriComponentsBuilder uriComponentsBuilder) {
        MaterialIdDTO materialDTO = materialService.createMaterial(body);

        var uri = uriComponentsBuilder.path("/materiais/{id}").buildAndExpand(materialDTO.id()).toUri();

        return ResponseEntity.created(uri).body(materialDTO);
    }

}

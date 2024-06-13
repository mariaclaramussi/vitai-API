package com.example.vitai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.SubExameTipo;

@Repository
public interface SubExameTipoRepository extends JpaRepository<SubExameTipo, Integer>{
    
    Optional<List<SubExameTipo>> findAllByExameTipoId(Integer id);
}

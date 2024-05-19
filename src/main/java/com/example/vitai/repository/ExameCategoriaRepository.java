package com.example.vitai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.ExameCategoria;

@Repository
public interface ExameCategoriaRepository extends JpaRepository<ExameCategoria, Integer> {

}

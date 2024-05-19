package com.example.vitai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.ExameTipo;

@Repository
public interface ExameTipoRepository extends JpaRepository<ExameTipo, Integer> {

}
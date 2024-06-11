package com.example.vitai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.ExameTipo;

@Repository
public interface ExameTipoRepository extends JpaRepository<ExameTipo, Integer> {

    @SuppressWarnings("null")
    Optional<ExameTipo> findById(Integer id);
}

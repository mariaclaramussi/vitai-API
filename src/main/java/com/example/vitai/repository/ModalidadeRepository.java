package com.example.vitai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.Modalidade;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {

    @SuppressWarnings("null")
    Optional<Modalidade> findById(Integer id);
}

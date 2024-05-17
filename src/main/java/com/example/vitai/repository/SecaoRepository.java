package com.example.vitai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.Secao;

@Repository
public interface SecaoRepository extends JpaRepository<Secao, Integer>{

}

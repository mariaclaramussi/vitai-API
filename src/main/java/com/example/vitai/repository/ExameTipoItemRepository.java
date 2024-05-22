package com.example.vitai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.ExameTipoItem;

@Repository
public interface ExameTipoItemRepository extends JpaRepository<ExameTipoItem, Integer>{

}
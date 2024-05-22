package com.example.vitai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>{

}

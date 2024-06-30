package com.example.vitai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vitai.domain.Pessoa;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Pessoa findByIdAndTipo(Integer id, String tipo);

    List<Pessoa> findAllByTipo(String tipo);

    Pessoa findById(int id);
}

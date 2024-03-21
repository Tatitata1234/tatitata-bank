package com.example.tatitatabank.repository;

import com.example.tatitatabank.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByIdPessoaAndAtivoIs(Long id,char ativo);

}

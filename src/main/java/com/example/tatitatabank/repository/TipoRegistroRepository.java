package com.example.tatitatabank.repository;

import com.example.tatitatabank.model.TipoRegistro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoRegistroRepository extends JpaRepository<TipoRegistro, Long> {
    Optional<TipoRegistro> findByIdTipoRegistroAndAtivoIs(Long id, char ativo);
}

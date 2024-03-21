package com.example.tatitatabank.repository;

import com.example.tatitatabank.controller.request.registro.RegistroRequest;
import com.example.tatitatabank.model.Pessoa;
import com.example.tatitatabank.model.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {
    List<Registro> findAllByAtivoIsAndPessoaAndPessoaAtivoIsAndTipoRegistroEntradaAndTipoRegistroAtivoIs(char ativo, Pessoa pessoa, char pessoaAtivo, Character character, char tipoRegistroAtivo);

    Optional<Registro> findByIdRegistroAndAtivoIs(RegistroRequest request, char ativo);
}

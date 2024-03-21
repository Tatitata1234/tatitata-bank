package com.example.tatitatabank.service.pessoa;

import com.example.tatitatabank.exception.NaoEncontradoException;
import com.example.tatitatabank.model.Pessoa;
import com.example.tatitatabank.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaEncontrarService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa porId(Long id) {
        Optional<Pessoa> pessoa = repository.findByIdPessoaAndAtivoIs(id, 'S');
        if (pessoa.isEmpty()) {
            throw new NaoEncontradoException("pessoa");
        }

        return pessoa.get();
    }
}

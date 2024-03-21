package com.example.tatitatabank.service.emprego;

import com.example.tatitatabank.exception.NaoEncontradoException;
import com.example.tatitatabank.model.Emprego;
import com.example.tatitatabank.model.Pessoa;
import com.example.tatitatabank.repository.EmpregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpregoEncontrarService {

    @Autowired
    private EmpregoRepository repository;

    public Emprego porId(Long id) {
        Optional<Emprego> entidade = repository.findByIdEmpregoAndAtivoIs(id, 'S');
        if (entidade.isEmpty()) {
            throw new NaoEncontradoException("emprego");
        }

        return entidade.get();
    }
}

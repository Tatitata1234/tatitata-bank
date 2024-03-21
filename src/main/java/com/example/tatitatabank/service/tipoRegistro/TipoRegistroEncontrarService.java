package com.example.tatitatabank.service.tipoRegistro;

import com.example.tatitatabank.exception.NaoEncontradoException;
import com.example.tatitatabank.model.Emprego;
import com.example.tatitatabank.model.TipoRegistro;
import com.example.tatitatabank.repository.TipoRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoRegistroEncontrarService {

    @Autowired
    private TipoRegistroRepository repository;

    public TipoRegistro porId(Long id) {
        Optional<TipoRegistro> entidade = repository.findByIdTipoRegistroAndAtivoIs(id, 'S');
        if (entidade.isEmpty()) {
            throw new NaoEncontradoException("tipo registro");
        }
        return entidade.get();
    }
}

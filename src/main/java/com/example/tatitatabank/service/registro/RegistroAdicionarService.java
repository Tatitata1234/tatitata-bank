package com.example.tatitatabank.service.registro;

import com.example.tatitatabank.controller.request.registro.RegistroRequest;
import com.example.tatitatabank.controller.response.registro.RegistroResponse;
import com.example.tatitatabank.exception.JaExisteException;
import com.example.tatitatabank.model.Registro;
import com.example.tatitatabank.model.TipoRegistro;
import com.example.tatitatabank.repository.PessoaRepository;
import com.example.tatitatabank.repository.RegistroRepository;
import com.example.tatitatabank.repository.TipoRegistroRepository;
import com.example.tatitatabank.service.pessoa.PessoaEncontrarService;
import com.example.tatitatabank.service.tipoRegistro.TipoRegistroEncontrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegistroAdicionarService {

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private PessoaEncontrarService pessoaEncontrarService;

    @Autowired
    private TipoRegistroEncontrarService tipoRegistroEncontrarService;

    public RegistroResponse adicionar(RegistroRequest request) {

        TipoRegistro tipoRegistro = tipoRegistroEncontrarService.porId(request.getTipoRegistro());

        Registro registro = Registro.builder()
                .tipoRegistro(tipoRegistro)
                .pessoa(pessoaEncontrarService.porId(request.getPessoa()))
                .valor(request.getValor())
                .build();
        registro.setCompetencia(LocalDateTime.now());
        registro.setAtivo('S');
        registroRepository.save(registro);
        return null;
    }

}

package com.example.tatitatabank.service.registro;

import com.example.tatitatabank.controller.response.RegistroSomaResponse;
import com.example.tatitatabank.model.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RegistroCalcularService {

    @Autowired
    private RegistroEncontrarService registroEncontrarService;

    public RegistroSomaResponse somarPorPessoaEEntrada(Long id, char entrada) {
        List<Registro> registros = registroEncontrarService.listarByPessoaAndEntrada(id,entrada);

        BigDecimal total = registros.stream().map(Registro::getValor).reduce(BigDecimal.valueOf(0), BigDecimal::add);

        return RegistroSomaResponse.builder().soma(total).build();
    }
}

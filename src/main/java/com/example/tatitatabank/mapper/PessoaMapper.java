package com.example.tatitatabank.mapper;

import com.example.tatitatabank.controller.response.pessoa.PessoaResponse;
import com.example.tatitatabank.model.Pessoa;

public class PessoaMapper {
    public static PessoaResponse toResponse(Pessoa entidade, String mensagem) {
        return PessoaResponse.builder()
                .id(entidade.getIdPessoa())
                .mensagem(mensagem)
                .build();
    }
}

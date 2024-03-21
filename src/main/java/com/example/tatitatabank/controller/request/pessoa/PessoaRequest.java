package com.example.tatitatabank.controller.request.pessoa;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {
    private Long idPessoa;

    private String nome;

    private Long emprego;

    private String apelido;

}

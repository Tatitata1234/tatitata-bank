package com.example.tatitatabank.controller.response.pessoa;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {
    private String mensagem;
    private Long id;
}

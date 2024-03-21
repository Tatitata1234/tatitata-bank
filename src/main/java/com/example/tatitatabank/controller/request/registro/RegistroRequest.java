package com.example.tatitatabank.controller.request.registro;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroRequest {

    private BigDecimal valor;

    private Long tipoRegistro;

    private Long pessoa;

}

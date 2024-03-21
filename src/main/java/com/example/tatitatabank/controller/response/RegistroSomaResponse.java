package com.example.tatitatabank.controller.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroSomaResponse {
    private BigDecimal soma;
}

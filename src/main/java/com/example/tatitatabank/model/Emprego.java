package com.example.tatitatabank.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Emprego {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id_emprego")
    private Long idEmprego;

    private String nome;

    private String descricao;

    private BigDecimal salario;

    private char ativo;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataInicial;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataFinal;
}

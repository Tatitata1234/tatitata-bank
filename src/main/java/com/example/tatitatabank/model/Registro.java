package com.example.tatitatabank.model;

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
public class Registro {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id_registro")
    private Long idRegistro;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_tipo_registro", referencedColumnName = "id_tipo_registro")
    private TipoRegistro tipoRegistro;

    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private Pessoa pessoa;

    private char ativo;

    private LocalDateTime competencia;
}

package com.example.tatitatabank.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoRegistro {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_registro")
    private Long idTipoRegistro;

    private String nome;

    private char entrada;

    private char ativo;
}

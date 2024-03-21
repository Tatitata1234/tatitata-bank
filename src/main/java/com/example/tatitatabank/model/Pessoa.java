package com.example.tatitatabank.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pessoa")
    private Long idPessoa;

    private String nome;

    @OneToOne
    @JoinColumn(name = "id_emprego", referencedColumnName = "id_emprego")
    private Emprego emprego;

    private String apelido;

    private char ativo;
}

package com.example.tatitatabank.controller;

import com.example.tatitatabank.controller.request.pessoa.PessoaRequest;
import com.example.tatitatabank.controller.response.pessoa.PessoaResponse;
import com.example.tatitatabank.model.Pessoa;
import com.example.tatitatabank.service.pessoa.PessoaAdicionarService;
import com.example.tatitatabank.service.pessoa.PessoaEncontrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaAdicionarService pessoaAdicionarService;

    @Autowired
    private PessoaEncontrarService pessoaEncontrarService;

    @PutMapping
    public ResponseEntity<PessoaResponse> adicionar(@RequestBody PessoaRequest request) {
        PessoaResponse response = pessoaAdicionarService.adicionar(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Pessoa> findById(@RequestBody Long idPessoa) {
        Pessoa pessoa = pessoaEncontrarService.porId(idPessoa);
        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }
}

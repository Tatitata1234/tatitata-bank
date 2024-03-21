package com.example.tatitatabank.controller;

import com.example.tatitatabank.controller.request.registro.RegistroSomaPorPessoaRequest;
import com.example.tatitatabank.controller.request.registro.RegistroRequest;
import com.example.tatitatabank.controller.response.RegistroSomaResponse;
import com.example.tatitatabank.controller.response.registro.RegistroResponse;
import com.example.tatitatabank.model.Registro;
import com.example.tatitatabank.service.registro.RegistroAdicionarService;
import com.example.tatitatabank.service.registro.RegistroCalcularService;
import com.example.tatitatabank.service.registro.RegistroEncontrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private RegistroAdicionarService registroAdicionarService;

    @Autowired
    private RegistroEncontrarService registroEncontrarService;

    @Autowired
    private RegistroCalcularService registroCalcularService;

    @PutMapping
    public ResponseEntity<RegistroResponse> adicionar(@RequestBody RegistroRequest request) {

        RegistroResponse response = registroAdicionarService.adicionar(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Registro>> listarByPessoaAndEntrada(@RequestBody RegistroSomaPorPessoaRequest request) {
        List<Registro> registroList = registroEncontrarService.listarByPessoaAndEntrada(request.getIdPessoa(), 'S');
        return new ResponseEntity<>(registroList, HttpStatus.CREATED);
    }

    @GetMapping("/total")
    public ResponseEntity<RegistroSomaResponse> somarTotalPorPessoaEEntrada(@RequestBody RegistroSomaPorPessoaRequest request) {
        RegistroSomaResponse registroList = registroCalcularService.somarPorPessoaEEntrada(request.getIdPessoa(), 'S');
        return new ResponseEntity<>(registroList, HttpStatus.CREATED);
    }
}

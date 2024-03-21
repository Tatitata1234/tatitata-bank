package com.example.tatitatabank.controller;

import com.example.tatitatabank.model.TipoRegistro;
import com.example.tatitatabank.service.tipoRegistro.TipoRegistroAdicionarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipo-registro")
public class TipoRegistroController {
    @Autowired
    private TipoRegistroAdicionarService TipoRegistroAdicionarService;

    @PutMapping
    public ResponseEntity<List<TipoRegistro>> adicionar(@RequestBody List<TipoRegistro> tipoRegistroList) {

        TipoRegistroAdicionarService.adicionar(tipoRegistroList);
        return new ResponseEntity<>(tipoRegistroList, HttpStatus.CREATED);
    }
}

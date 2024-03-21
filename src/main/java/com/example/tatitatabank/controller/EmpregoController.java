package com.example.tatitatabank.controller;

import com.example.tatitatabank.model.Emprego;
import com.example.tatitatabank.service.emprego.EmpregoAdicionarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprego")
public class EmpregoController {

    @Autowired
    private EmpregoAdicionarService empregoAdicionarService;

    @PutMapping
    public ResponseEntity<Emprego> adicionar(@RequestBody Emprego emprego) {

        empregoAdicionarService.adicionar(emprego);
        return new ResponseEntity<>(emprego, HttpStatus.CREATED);
    }
}

package com.example.tatitatabank.service.emprego;

import com.example.tatitatabank.model.Emprego;
import com.example.tatitatabank.repository.EmpregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpregoAdicionarService {

    @Autowired
    private EmpregoRepository empregoRepository;

    public void adicionar(Emprego emprego) {
        emprego.setAtivo('S');
        empregoRepository.save(emprego);
    }
}

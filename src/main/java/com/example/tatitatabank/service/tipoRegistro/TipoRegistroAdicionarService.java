package com.example.tatitatabank.service.tipoRegistro;

import com.example.tatitatabank.model.TipoRegistro;
import com.example.tatitatabank.repository.TipoRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoRegistroAdicionarService {

    @Autowired
    private TipoRegistroRepository tipoRegistroRepository;

    public void adicionar(List<TipoRegistro> tipoRegistroList) {
        tipoRegistroList.forEach(item-> item.setAtivo('S'));
        tipoRegistroRepository.saveAll(tipoRegistroList);
    }
}

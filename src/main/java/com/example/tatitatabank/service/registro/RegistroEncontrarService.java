package com.example.tatitatabank.service.registro;

import com.example.tatitatabank.model.Registro;
import com.example.tatitatabank.repository.RegistroRepository;
import com.example.tatitatabank.service.pessoa.PessoaEncontrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroEncontrarService {

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private PessoaEncontrarService pessoaEncontrarService;

    public List<Registro> listarByPessoaAndEntrada(Long idPessoa, Character entrada) {

        return registroRepository.findAllByAtivoIsAndPessoaAndPessoaAtivoIsAndTipoRegistroEntradaAndTipoRegistroAtivoIs(
                'S',
                pessoaEncontrarService.porId(idPessoa),
                'S',
                entrada,
                'S'
        );
    }
}

package com.example.tatitatabank.service.pessoa;

import com.example.tatitatabank.controller.request.pessoa.PessoaRequest;
import com.example.tatitatabank.controller.response.pessoa.PessoaResponse;
import com.example.tatitatabank.exception.JaExisteException;
import com.example.tatitatabank.exception.NaoEncontradoException;
import com.example.tatitatabank.mapper.PessoaMapper;
import com.example.tatitatabank.model.Emprego;
import com.example.tatitatabank.model.Pessoa;
import com.example.tatitatabank.repository.EmpregoRepository;
import com.example.tatitatabank.repository.PessoaRepository;
import com.example.tatitatabank.service.emprego.EmpregoEncontrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaAdicionarService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmpregoEncontrarService empregoEncontrarService;

    public PessoaResponse adicionar(PessoaRequest request) {
        Emprego emprego = empregoEncontrarService.porId(request.getEmprego());

        Pessoa pessoa = Pessoa.builder()
                .idPessoa(request.getIdPessoa())
                .apelido(request.getApelido())
                .ativo('S')
                .nome(request.getNome())
                .emprego(emprego)
                .build();
        pessoaRepository.save(pessoa);
        return PessoaMapper.toResponse(pessoa, System.getProperty("mensagem.sucesso"));
    }
}

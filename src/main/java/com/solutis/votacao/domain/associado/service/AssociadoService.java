package com.solutis.votacao.domain.associado.service;

import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.associado.repository.AssociadoRepository;

import java.util.List;

public class AssociadoService {

    private AssociadoRepository associadoRepository;


    public List<Associado> listarTodos(){return associadoRepository.findAll();}


    public Associado criarAssociado(Associado associado) {
        associadoRepository.save(associado);
        return associado;
    }
}

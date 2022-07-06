package com.solutis.votacao.domain.pauta.service;

import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.reponsedto.PautaResponseDTO;
import com.solutis.votacao.domain.pauta.repository.PautaRepository;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import com.solutis.votacao.domain.sessao.repository.SessaoRepository;
import com.solutis.votacao.domain.voto.entity.Voto;
import com.solutis.votacao.domain.voto.repository.VotoRepository;
import com.solutis.votacao.execption.Error;
import com.solutis.votacao.execption.RunAppExecption;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class PautaService{
    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    private VotoRepository votoRepository;

    public Pauta criarPauta(Pauta pauta){
        pautaRepository.save(pauta);
        return pauta;
    }

    public List<Pauta> listarPautas(){return pautaRepository.findAll();}

    public Optional<Pauta> pegarPauta(Long id){ return pautaRepository.findById(id);}

    private Optional<Sessao> pegarSessaoVotacaoByPauta(Pauta pauta){ return sessaoRepository.findByPauta(pauta);}

    public void deletePorId(Long id){
        if(pautaRepository.existsById(id)){
            pautaRepository.deleteById(id);
        }
    }





/*
    public Map<String, Long> resultado(Pauta pauta) {

        Collection<Voto> votos = pegarSessaoVotacaoByPauta(pauta).isPresent() ? pegarSessaoVotacaoByPauta(pauta).get().getVotos() : new ArrayList<>();

        Map<String, Long> result = new HashMap<>();
        result.put("SIM", votos.stream().filter(v -> v.getOpcaoVoto().equals(true)).count());
        result.put("NAO", votos.stream().filter(v -> v.getOpcaoVoto().equals(false)).count());

        return result;
    }

 */

    public Map<String, Long>  calcularResultado(Long id) {
        Pauta pauta = pautaRepository.findById(id).orElseThrow(()-> new RunAppExecption(Error.PAUTA_NAO_ENCONTRADA));
        Collection<Voto> votos = pegarSessaoVotacaoByPauta(pauta).isPresent() ? pegarSessaoVotacaoByPauta(pauta).get().getVotos() : new ArrayList<>();

        Map<String, Long> result = new HashMap<>();
        result.put("SIM", votos.stream().filter(v -> v.getOpcaoVoto().equals(true)).count());
        result.put("NAO", votos.stream().filter(v -> v.getOpcaoVoto().equals(false)).count());

        /*
        {totalVotos: x,
        percentcual: {Sim: 10%, nao: 90%}
        }
         */


        // calcular percentual com double
        // StringFortmatter para formatar a porcentagem 30%

        return result;

    }
}

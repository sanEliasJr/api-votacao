package com.solutis.votacao.domain.sessao.service;

import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.repository.PautaRepository;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import com.solutis.votacao.domain.sessao.repository.SessaoRepository;
import com.solutis.votacao.execption.Error;
import com.solutis.votacao.execption.RunAppExecption;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private PautaRepository pautaRepository;

    private static final Integer tempoSessaoPadrao = 60;

    public Integer pegarTempoSessaPadrao(){
        return tempoSessaoPadrao;
    }


    public Optional<Pauta> pegarPauta(Long id) {return pautaRepository.findById(id);}

    public void iniciarSessao(Long idPauta, Integer minuto) {
        Pauta pauta = pegarPauta(idPauta).orElseThrow(() -> new RunAppExecption(Error.PAUTA_NAO_ENCONTRADA));
        if (Objects.requireNonNull(pegarSessao(pauta)).isPresent()){
            throw new RunAppExecption(Error.SESSAO_JA_EXISTE);
        }
        criarSessao(pauta, minuto);
    }

    private void criarSessao(Pauta pauta, Integer minuto) {
        Sessao sessao = new Sessao();
        sessao.setDataAbertura(LocalDateTime.now());
        sessao.setDataFechamento(dataFechamento(minuto));
        sessao.setPauta(pauta);

        sessaoRepository.save(sessao);
    }


    private Optional<Sessao> pegarSessao(Pauta pauta) {return sessaoRepository.findByPauta(pauta);}

    private LocalDateTime dataFechamento(Integer minutos){
        return minutos == null ? LocalDateTime.now().plusSeconds(tempoSessaoPadrao) : LocalDateTime.now().plusSeconds((long) minutos *tempoSessaoPadrao) ;
    }


}
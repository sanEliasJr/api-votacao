package com.solutis.votacao.domain.voto.service;

import com.solutis.votacao.domain.associado.repository.AssociadoRepository;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.repository.PautaRepository;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import com.solutis.votacao.domain.sessao.repository.SessaoRepository;
import com.solutis.votacao.domain.voto.dto.VotoDTO;
import com.solutis.votacao.domain.voto.entity.Voto;
import com.solutis.votacao.domain.voto.repository.VotoRepository;
import com.solutis.votacao.execption.Error;
import com.solutis.votacao.execption.RunAppExecption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VotoService {

    private PautaRepository pautaRepository;

    private SessaoRepository sessaoRepository;

    private VotoRepository votoRepository;

    private AssociadoRepository associadoRepository;

    public Optional<Pauta> pegarPauta(Long id){ return pautaRepository.findById(id);}

    private Optional<Sessao> pegarSessaoVotacao(Pauta pauta){ return sessaoRepository.findByPauta(pauta);}

    public void votar(Long idPauta, VotoDTO votoDTO){
        Voto voto = new Voto();
        Sessao sessao = pegarSessaoVotacao(pegarPauta(idPauta)
                .orElseThrow(()-> new RunAppExecption(Error.PAUTA_NAO_ENCONTRADA)))
                .orElseThrow(()-> new RunAppExecption(Error.SESSAO_NAO_ENCONTRADA));
        if(LocalDateTime.now().isAfter(sessao.getDataFechamento())){
            throw new RunAppExecption(Error.SESSAO_FECHADA);
        }

        if(votoRepository.existsBySessaoAndIdAssociado(sessao.getId(), votoDTO.getIdAssociado()).isPresent()){
            throw new RunAppExecption(Error.VOTO_JA_REGISTRADO);
        }

        voto.setAssociado(associadoRepository.getById(votoDTO.getIdAssociado()));
        voto.setSessao(sessao);
        voto.setDataHoraVoto(LocalDateTime.now());
        voto.setOpcaoVoto(votoDTO.getOpcaoVoto());

        votoRepository.save(voto);
    }

    public void pautaEncontrada(Long id){
        pegarPauta(id).orElseThrow(()-> new RunAppExecption(Error.PAUTA_NAO_ENCONTRADA));
    }

}

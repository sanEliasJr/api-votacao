package com.solutis.votacao.domain.pauta.service;

import com.solutis.votacao.domain.common.service.BaseServiceImpl;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.repository.PautaRepository;
import com.solutis.votacao.execption.Error;
import com.solutis.votacao.execption.RunAppExecption;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class PautaService{
    @Autowired
    private PautaRepository pautaRepository;

    public Pauta savePauta(Pauta pauta){
        pautaRepository.save(pauta);
        return pauta;
    }

    public List<Pauta> getPautas(){return pautaRepository.findAll();}

    public Optional<Pauta> getPauta(Long id){return pautaRepository.findById(id);}


    public void deleteById(Long id){
        if(pautaRepository.existsById(id)){
            pautaRepository.deleteById(id);
        }
    }





//    @Override
//    public void beforeSave(Pauta entity){
//        try {
//            Optional<Pauta> pautaSalvo = pautaRepository.findAll().stream()
//                    .filter(pauta -> entity.getNome().equals(pauta.getNome()))
//                    .findFirst();
//            if(pautaSalvo.isPresent()){
//                throw new RunAppExecption(Error.PAUTA_JA_CADASTRADA);
//            }
//        } catch (RuntimeException runAppException){
//            throw runAppException;
//        }
//    }

}

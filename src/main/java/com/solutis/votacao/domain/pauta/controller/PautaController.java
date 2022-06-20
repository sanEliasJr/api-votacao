package com.solutis.votacao.domain.pauta.controller;

import com.solutis.votacao.domain.pauta.dto.PautaDTO;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.service.PautaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@AllArgsConstructor
@RestController
@RequestMapping(value = "pauta")
@Slf4j
public class PautaController {

    private PautaService pautaService;

    public ResponseEntity save(@RequestBody PautaDTO.save dto){
        return  new ResponseEntity(pautaService.save(Pauta.builder()
                .nome(dto.getNome())
                .build()), HttpStatus.OK);
    }

}

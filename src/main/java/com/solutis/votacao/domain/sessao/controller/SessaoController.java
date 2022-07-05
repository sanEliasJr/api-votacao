package com.solutis.votacao.domain.sessao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutis.votacao.domain.sessao.dto.SessaoDTO;
import com.solutis.votacao.domain.sessao.service.SessaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sessao")
@AllArgsConstructor
public class SessaoController {

    private SessaoService sessaoService;

    @PostMapping
    public ResponseEntity iniciarSessao(@RequestBody @Valid SessaoDTO sessaoDTO){

        sessaoService.iniciarSessao(sessaoDTO.getIdPauta(),sessaoDTO.getDataFechamento());

        return ResponseEntity.ok().build();
    }
}

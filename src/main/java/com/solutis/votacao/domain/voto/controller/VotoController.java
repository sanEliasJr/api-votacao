package com.solutis.votacao.domain.voto.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutis.votacao.domain.voto.dto.VotoDTO;
import com.solutis.votacao.domain.voto.entity.Voto;
import com.solutis.votacao.domain.voto.service.VotoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/voto")
@AllArgsConstructor
public class VotoController {

    @Autowired
    private VotoService votoService;

    private ObjectMapper objectMapper;

    @PostMapping("/{idPauta}/votar")
    public ResponseEntity votar(@PathVariable("idPauta") Long idPauta,  @RequestBody @Valid VotoDTO votoDTO){
        votoService.votar(idPauta, objectMapper.convertValue(votoDTO, Voto.class));
        return ResponseEntity.ok().build();
    }
}

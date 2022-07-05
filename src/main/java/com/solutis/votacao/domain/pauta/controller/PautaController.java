package com.solutis.votacao.domain.pauta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutis.votacao.domain.pauta.dto.PautaDTO;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.service.PautaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/pauta")
@Slf4j
public class PautaController {

    private PautaService pautaService;
    private ObjectMapper objectMapper;

    @GetMapping
    public List<Pauta>listarPauta(){
        return pautaService.getPautas();
    }

    @PostMapping
    public ResponseEntity<PautaDTO> criarPauta(@RequestBody @Valid PautaDTO pautaDTO){
        Pauta pauta = objectMapper.convertValue(pautaDTO, Pauta.class);
        pauta = pautaService.savePauta(pauta);

        return ResponseEntity.ok(objectMapper.convertValue(pauta, PautaDTO.class))
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{idPauta}")
    public void removerPauta(@PathVariable("idPauta")Long idPauta){
        pautaService.deleteById(idPauta);
    }

}

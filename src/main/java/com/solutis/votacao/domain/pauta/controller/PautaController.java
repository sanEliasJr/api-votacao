package com.solutis.votacao.domain.pauta.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutis.votacao.domain.pauta.dto.PautaDTO;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.reponsedto.PautaResponseDTO;
import com.solutis.votacao.domain.pauta.service.PautaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/pauta")
@Slf4j
public class PautaController {

    private PautaService pautaService;
    private ObjectMapper objectMapper;

    @GetMapping
    public List<Pauta>listarPauta(){
        return pautaService.listarPautas();
    }

    @PostMapping
    public ResponseEntity<PautaDTO> criarPauta(@RequestBody @Valid PautaDTO pautaDTO){
        Pauta pauta = objectMapper.convertValue(pautaDTO, Pauta.class);
        pauta = pautaService.criarPauta(pauta);

        return ResponseEntity.ok(objectMapper.convertValue(pauta, PautaDTO.class))
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{idPauta}")
    public void removerPauta(@PathVariable("idPauta")Long idPauta){
        pautaService.deletePorId(idPauta);
    }

    @GetMapping("/{idPauta}/resultado")
    public ResponseEntity<Map<String, Long>> pegarResultadodaPautaPorID(@PathVariable("idPauta") Long id){

         return  ResponseEntity.ok(pautaService.calcularResultado(id))
                 .status(HttpStatus.OK)
                 .build();
    }



}

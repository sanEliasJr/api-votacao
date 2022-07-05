package com.solutis.votacao.domain.associado.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutis.votacao.domain.associado.dto.AssociadoDTO;
import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.associado.service.AssociadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/associado")
public class AssociadoController {
    @Autowired
    private AssociadoService associadoService;
    private ObjectMapper objectMapper;


    @GetMapping
    public List<Associado> listarAssociados(){ return associadoService.listarTodos();}

    @PostMapping
    public ResponseEntity<AssociadoDTO> criarAssociado(@RequestBody @Valid AssociadoDTO associadoDTO){
        Associado associado = objectMapper.convertValue(associadoDTO, Associado.class);
        associado = associadoService.criarAssociado(associado);

        return ResponseEntity.ok(objectMapper.convertValue(associado, AssociadoDTO.class))
                .status(HttpStatus.CREATED)
                .build();
    }


}

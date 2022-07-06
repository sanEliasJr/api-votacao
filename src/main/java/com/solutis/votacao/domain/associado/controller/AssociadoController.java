package com.solutis.votacao.domain.associado.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutis.votacao.domain.associado.dto.AssociadoDTO;
import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.associado.service.AssociadoService;
import com.solutis.votacao.domain.pauta.reponsedto.PautaResponseDTO;
import com.solutis.votacao.domain.voto.entity.Voto;
import com.solutis.votacao.domain.voto.service.VotoService;
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

    private VotoService votoService;
    private ObjectMapper objectMapper;


    /**
     *
     * @return
     */
    @GetMapping
    public List<Associado> listarAssociados(){ return associadoService.listarTodos();}

    /**
     *
     * @param associadoDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<AssociadoDTO> criarAssociado(@RequestBody @Valid AssociadoDTO associadoDTO){
        Associado associado = objectMapper.convertValue(associadoDTO, Associado.class);
        associado = associadoService.criarAssociado(associado);

        return ResponseEntity.ok(objectMapper.convertValue(associado, AssociadoDTO.class))
                .status(HttpStatus.CREATED)
                .build();
    }


}

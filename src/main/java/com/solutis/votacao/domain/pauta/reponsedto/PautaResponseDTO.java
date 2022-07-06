package com.solutis.votacao.domain.pauta.reponsedto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class PautaResponseDTO {

    private String id;

    private String nome;

    private Map<String, Long>resultado;
}

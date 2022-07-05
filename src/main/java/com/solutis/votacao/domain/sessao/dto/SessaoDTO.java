package com.solutis.votacao.domain.sessao.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SessaoDTO {

    @ApiModelProperty(value = "Id da Pauta")
    private Long idPauta;

    @ApiModelProperty(value = "Data/Hora de fechamento da votação", example = "2022-07-07T08:28:20.223Z")
    private Integer dataFechamento;


}

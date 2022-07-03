package com.solutis.votacao.domain.pauta.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode
@ToString
public class PautaDTO {
    @ApiModelProperty(value = "Descrição da pauta em votação")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @ApiModelProperty(value = "Descrição da pauta em votação")
    private String descricao;


}

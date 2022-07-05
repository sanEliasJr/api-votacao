package com.solutis.votacao.domain.voto.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode
public class VotoDTO {

    @ApiModelProperty(value = "ID do Associado")
    @NotNull(message = "ID do Associado é obrigatório")
    private Long idAssociado;

    @ApiModelProperty(value = "Opção de voto do associado", example = "true / false")
    @NotNull(message = "Opção de voto é obrigatório")
    private Boolean opcaoVoto;
}

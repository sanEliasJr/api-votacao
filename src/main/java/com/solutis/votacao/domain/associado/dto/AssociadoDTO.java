package com.solutis.votacao.domain.associado.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
@EqualsAndHashCode
public class AssociadoDTO {

    @ApiModelProperty(value = "CPF do Associado", example = "38879890890")
    @NotNull(message = "CPF do Associado é obrigatório.")
    private Integer cpf;

    @ApiModelProperty(value = "Senha de Acesso Associado")
    @NotNull(message = "Senha de Associado Obrigatória.")
    private Integer senha;
}

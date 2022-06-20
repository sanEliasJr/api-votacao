package com.solutis.votacao.domain.pauta.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
@Builder
@JsonTypeName
public class PautaDTO {

    private Long id;

    private String nome;

    private String descricao;


    @Getter
    @AllArgsConstructor
    @Builder
    @JsonTypeName("pauta")
    public static class save{

        @NotNull
        private String nome;

    }

}

package com.solutis.votacao.domain.sessao.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonTypeName
public class SessaoDTO {

    private Long id;


    @Getter
    @Builder
    @AllArgsConstructor
    @JsonTypeName("sessao")
    public static class save{

        @NotNull
        private String nome;

    }
}

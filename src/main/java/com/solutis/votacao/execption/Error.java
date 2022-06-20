package com.solutis.votacao.execption;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum Error {

    PAUTA_JA_CADASTRADA("A  PAUTA JÁ  ESTÁ CADASTRADA", HttpStatus.UNPROCESSABLE_ENTITY);

    private final String mensagem;

    private final HttpStatus status;


    Error(String mensagem, HttpStatus status){
        this.mensagem = mensagem;
        this.status = status;
    }
}

package com.solutis.votacao.execption;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum Error {

    //PAUTA_JA_CADASTRADA("A  PAUTA JÁ  ESTÁ CADASTRADA", HttpStatus.UNPROCESSABLE_ENTITY),

    SESSAO_FECHADA("A SESSÃO JÁ FOI ENCERRADA!", HttpStatus.BAD_REQUEST),

    VOTO_JA_REGISTRADO("VOTO JÁ REGISTRADO!", HttpStatus.BAD_REQUEST),

    PAUTA_NAO_ENCONTRADA("PAUTA NÃO ENCONTRADA",HttpStatus.FAILED_DEPENDENCY),
    SESSAO_NAO_ENCONTRADA("A SESSÃO NÃO FOI ENCONTRADA", HttpStatus.NOT_FOUND),

    SESSAO_JA_EXISTE("SESSÃO JÁ EXISTE!",HttpStatus.FOUND);


    private final String mensagem;

    private final HttpStatus status;


    Error(String mensagem, HttpStatus status){
        this.mensagem = mensagem;
        this.status = status;
    }
}

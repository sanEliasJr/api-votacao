package com.solutis.votacao.execption;

import lombok.Getter;

@Getter
public class RunAppExecption extends  RuntimeException {

    private final Error error;

    public RunAppExecption(Error error){
        super(error.getMensagem());
        this.error = error;
    }
}

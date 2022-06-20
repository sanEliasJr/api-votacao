package com.solutis.votacao.execption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RunExceptionHandler {
    @ExceptionHandler(RunAppExecption.class)
    public ResponseEntity<String> handleRunAPPException(RunAppExecption runAppExecption){
        return new ResponseEntity<String>(
                runAppExecption.getError().getMensagem(),
                        runAppExecption.getError().getStatus());
    }
}

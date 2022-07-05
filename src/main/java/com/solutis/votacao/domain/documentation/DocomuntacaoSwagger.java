package com.solutis.votacao.domain.documentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ApiIgnore
@RestController
public class DocomuntacaoSwagger {
    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException{
        response.sendRedirect("swagger-ui.html");
    }
}
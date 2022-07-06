package com.solutis.votacao.service;

import com.solutis.votacao.domain.sessao.repository.SessaoRepository;
import com.solutis.votacao.domain.sessao.service.SessaoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(SessaoService.class)
public class SessaoServiceTest {

    @InjectMocks
    SessaoService sessaoService;


    @MockBean
    SessaoRepository sessaoRepository;





}

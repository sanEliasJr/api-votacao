package com.solutis.votacao.service;

import com.solutis.votacao.domain.associado.repository.AssociadoRepository;
import com.solutis.votacao.domain.associado.service.AssociadoService;
import com.solutis.votacao.domain.sessao.repository.SessaoRepository;
import com.solutis.votacao.domain.sessao.service.SessaoService;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(AssociadoService.class)
public class AssociadoServiceTest {

    @InjectMocks
    AssociadoService associadoService;

    @MockBean
    AssociadoRepository associadoRepository;








}

package com.solutis.votacao.repository;


import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.repository.PautaRepository;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import com.solutis.votacao.domain.sessao.repository.SessaoRepository;
import com.solutis.votacao.domain.sessao.service.SessaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SessaoEntityRepositoryTest {

    @Spy
    private SessaoRepository sessaoRepository;

    @Spy
    private PautaRepository pautaRepository;


    @InjectMocks
    SessaoService sessaoService;


    @Test
    void saveTest() {

        Pauta pauta = new Pauta();
        pauta.setId(1L);
        Sessao sessao = new Sessao();
        sessao.setId(1L);
        sessao.setPauta(pauta);

        when(sessaoRepository.save(any(Sessao.class))).thenReturn(sessao);
        when(pautaRepository.findById(any(Long.class))).thenReturn(Optional.of(pauta));

        Sessao sessao1 = sessaoService.iniciarSessao(1L, 2);

        Assert.isTrue(sessao1.getId().equals(sessao.getId()), "");
    }

}

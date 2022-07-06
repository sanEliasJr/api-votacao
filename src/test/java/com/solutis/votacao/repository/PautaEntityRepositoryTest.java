package com.solutis.votacao.repository;

import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.pauta.repository.PautaRepository;
import com.solutis.votacao.domain.pauta.service.PautaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PautaEntityRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @MockBean
    private PautaRepository pautaRepository;

    @Autowired
    PautaService pautaService;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
    }

    @Test
    void saveTest() {
        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setNome("pauta");
        pauta.setDescricao("descricao");
        when(pautaRepository.save(any(Pauta.class))).thenReturn(pauta);

        Pauta pauta1 = pautaService.criarPauta(pauta);

        Assert.isTrue(pauta1.getId().equals(pauta.getId()), "");
    }
}

package com.solutis.votacao.repository;


import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.associado.repository.AssociadoRepository;
import com.solutis.votacao.domain.associado.service.AssociadoService;
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
public class AssociadoEntityRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @MockBean
    private AssociadoRepository associadoRepository;

    @Autowired
    AssociadoService associadoService;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
    }

    @Test
    void saveTest() {
        Associado associado = new Associado();
        associado.setId(1L);
        associado.setNome("nome");
        associado.setCpf(1234);
        associado.setSenha(123);
        when(associadoRepository.save(any(Associado.class))).thenReturn(associado);

        Associado associado1 = associadoService.criarAssociado(associado);

        Assert.isTrue(associado1.getId().equals(associado.getId()), "");
    }
}

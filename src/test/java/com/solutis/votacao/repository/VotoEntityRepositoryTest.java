package com.solutis.votacao.repository;

import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.associado.repository.AssociadoRepository;
import com.solutis.votacao.domain.pauta.repository.PautaRepository;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import com.solutis.votacao.domain.sessao.repository.SessaoRepository;
import com.solutis.votacao.domain.voto.dto.VotoDTO;
import com.solutis.votacao.domain.voto.entity.Voto;
import com.solutis.votacao.domain.voto.repository.VotoRepository;
import com.solutis.votacao.domain.voto.service.VotoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VotoEntityRepositoryTest {

/*
    @MockBean
    private VotoRepository votoRepository;

    private AssociadoRepository associadoRepository;

    private SessaoRepository sessaoRepository;

    private PautaRepository pautaRepository;

    @InjectMocks
    VotoService votoService;


    @Test
    void saveTest() {
        Sessao sessao = new Sessao();
        Associado associado = new Associado();
        VotoDTO votoDTO = new VotoDTO();
        votoDTO.setIdAssociado(1L);
        votoDTO.setOpcaoVoto(true);

        when(votoRepository.save(any(Voto.class))).thenReturn(votoDTO);

        Voto voto1 = votoService.votar(1,votoDTO);

        Assert.isTrue(voto1.getId().equals(votoDTO.getId()), "");
    }



 */
}

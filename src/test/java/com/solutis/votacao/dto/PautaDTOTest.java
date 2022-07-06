package com.solutis.votacao.dto;

import com.solutis.votacao.domain.pauta.dto.PautaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class PautaDTOTest {

    @Test
    public void setDTOTest(){
        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setNome("pauta1");
        pautaDTO.setDescricao("descriacao");

        Assert.isTrue(pautaDTO.getNome().equalsIgnoreCase("pauta1"),"");
    }
}

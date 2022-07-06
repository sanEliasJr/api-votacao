package com.solutis.votacao.dto;

import com.solutis.votacao.domain.pauta.dto.PautaDTO;
import com.solutis.votacao.domain.sessao.dto.SessaoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class SessaoDTOTest {
    @Test
    public void setDTOTest(){
        SessaoDTO sessaoDTO = new SessaoDTO();
        sessaoDTO.setIdPauta(1L);

        Assert.isTrue(sessaoDTO.getIdPauta().equals(1L),"");
    }
}

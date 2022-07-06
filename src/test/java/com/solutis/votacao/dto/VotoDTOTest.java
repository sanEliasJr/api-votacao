package com.solutis.votacao.dto;

import com.solutis.votacao.domain.pauta.dto.PautaDTO;
import com.solutis.votacao.domain.voto.dto.VotoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class VotoDTOTest {
    @Test
    public void setDTOTest(){
        VotoDTO votoDTO = new VotoDTO();
        votoDTO.setOpcaoVoto(true);
        votoDTO.setIdAssociado(1L);

        Assert.isTrue(votoDTO.getOpcaoVoto().equals(true),"");
        Assert.isTrue(votoDTO.getIdAssociado().equals(1L),"");
    }
}

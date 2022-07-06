package com.solutis.votacao.dto;

import com.solutis.votacao.domain.associado.dto.AssociadoDTO;
import com.solutis.votacao.domain.pauta.dto.PautaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class AssociadoDTOTest {
    @Test
    public void setDTOTest(){
        AssociadoDTO associadoDTO = new AssociadoDTO();
        associadoDTO.setNome("Elias");
        associadoDTO.setCpf(1234);
        associadoDTO.setSenha(123);

        Assert.isTrue(associadoDTO.getCpf().equals(1234),"");
        Assert.isTrue(associadoDTO.getNome().equalsIgnoreCase("Elias"),"");
        Assert.isTrue(associadoDTO.getSenha().equals(123),"");
    }
}

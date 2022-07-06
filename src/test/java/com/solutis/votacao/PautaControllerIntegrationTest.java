package com.solutis.votacao;

import com.solutis.votacao.domain.pauta.controller.PautaController;
import com.solutis.votacao.domain.pauta.service.PautaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class PautaControllerIntegrationTest {

    private MockMvc mockMvc;

    @Mock
    private PautaService service;

    @InjectMocks
    private PautaController controller;

    @Before
    public void setup(){mockMvc = MockMvcBuilders.standaloneSetup(controller).build();}

    @Test
    public void getPautas() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/pauta").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addPauta() throws Exception {
        String json = "{\n" +
                "  \"nome\": \"nomepauta\"\n" +
                "  \"descricao\": \"descricao\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/pauta").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void iniciarSessao() throws Exception {
        String json = "{\n" +
                "  \"dataFechamento\": \"10\"\n" +
                "  \"idPauta\": \"1\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/sessao/").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void criarAssociado() throws Exception {
        String json = "{\n" +
                "  \"cpf\": \"128789\"\n" +
                "  \"nome\": \"Elias\"\n" +
                "  \"senha\": \"123\"\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/sessao/").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void votarPauta() throws Exception {
        String json = "{\n" +
                "  \"idAssociado\": \"1\"\n" +
                "  \"opcaoVoto\": \"true\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("pauta/voto/1/votar").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }



    @Test
    public void getPauta() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pauta", 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}

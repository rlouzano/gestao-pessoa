package br.com.gestao.pessoa.web.controlers;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.entity.enums.TipoDocumentoSistema;
import br.com.gestao.pessoa.ports.in.web.AtualizarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.in.web.DeletarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.in.web.GetPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.in.web.SalvarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.web.requests.PessoaGestaoSistemaRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PessoaGestaoSistemaControllerImpl.class)
public class PessoaGestaoSistemaControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetPessoaGestaoSistemaUseCasePort getPessoaGestaoSistemaUseCasePort;

    @MockBean
    private SalvarPessoaGestaoSistemaUseCasePort salvarPessoaGestaoSistemaUseCasePort;

    @MockBean
    private AtualizarPessoaGestaoSistemaUseCasePort atualizarPessoaGestaoSistemaUseCasePort;

    @MockBean
    private DeletarPessoaGestaoSistemaUseCasePort deletarPessoaGestaoSistemaUseCasePort;

    private static final String API_KEY = "test-key";
    private static final UUID CORRELATION_ID = UUID.randomUUID();

    private PessoaGestaoSistemaDTO buildDto(Integer id) {
        PessoaGestaoSistemaDTO dto = new PessoaGestaoSistemaDTO();
        dto.setCodigoPessoaSistema(id);
        dto.setNomePessoaSistema("Nome " + id);
        dto.setTipoDocumentoSistema(TipoDocumentoSistema.CPF);
        dto.setNumeroDocumentoSistema(123456789);
        dto.setIndicadorPessoaAtiva(true);
        return dto;
    }

    @Test
    public void shouldReturnListOfPeople() throws Exception {
        List<PessoaGestaoSistemaDTO> dtos = Arrays.asList(buildDto(1), buildDto(2));
        when(getPessoaGestaoSistemaUseCasePort.getPessoaGestaoSistema()).thenReturn(dtos);

        mockMvc.perform(get("/api/gestao")
                        .header("api_key", API_KEY)
                        .header("currelation_id", CORRELATION_ID.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].codigoPessoaSistema").value(1))
                .andExpect(jsonPath("$[0].nomePessoaSistema").value("Nome 1"))
                .andExpect(jsonPath("$[1].codigoPessoaSistema").value(2));
    }

    @Test
    public void shouldReturnPersonById() throws Exception {
        PessoaGestaoSistemaDTO dto = buildDto(5);
        when(getPessoaGestaoSistemaUseCasePort.getPessoaGestaoSistemaPorIdPessoa(eq(5))).thenReturn(dto);

        mockMvc.perform(get("/api/gestao/5")
                        .header("api_key", API_KEY)
                        .header("currelation_id", CORRELATION_ID.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigoPessoaSistema").value(5))
                .andExpect(jsonPath("$.nomePessoaSistema").value("Nome 5"));
    }

    @Test
    public void shouldCreatePerson() throws Exception {
        PessoaGestaoSistemaRequest request = PessoaGestaoSistemaRequest.builder()
                .nomePessoaSistema("Novo Nome")
                .tipoDocumentoSistema(TipoDocumentoSistema.CPF)
                .numeroDocumentoSistema(987654321)
                .indicadorPessoaAtiva(true)
                .build();

        PessoaGestaoSistemaDTO created = buildDto(10);
        when(salvarPessoaGestaoSistemaUseCasePort.createPessoaGestaoSistemaRequest(any(PessoaGestaoSistemaRequest.class))).thenReturn(created);

        mockMvc.perform(post("/api/gestao")
                        .header("api_key", API_KEY)
                        .header("currelation_id", CORRELATION_ID.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.codigoPessoaSistema").value(10))
                .andExpect(jsonPath("$.nomePessoaSistema").value("Nome 10"));
    }

    @Test
    public void shouldUpdatePerson() throws Exception {
        PessoaGestaoSistemaRequest request = PessoaGestaoSistemaRequest.builder()
                .nomePessoaSistema("Atualizado")
                .build();

        PessoaGestaoSistemaDTO updated = buildDto(15);
        when(atualizarPessoaGestaoSistemaUseCasePort.updatePessoaGestaoSistema(eq(15), any(PessoaGestaoSistemaRequest.class))).thenReturn(updated);

        mockMvc.perform(put("/api/gestao/15")
                        .header("api_key", API_KEY)
                        .header("currelation_id", CORRELATION_ID.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigoPessoaSistema").value(15))
                .andExpect(jsonPath("$.nomePessoaSistema").value("Nome 15"));
    }

    @Test
    public void shouldDeletePerson() throws Exception {
        // no need to stub for void

        mockMvc.perform(delete("/api/gestao/20")
                        .header("api_key", API_KEY)
                        .header("currelation_id", CORRELATION_ID.toString()))
                .andExpect(status().isNoContent());

        verify(deletarPessoaGestaoSistemaUseCasePort, times(1)).deletePessoaGestaoSistema(eq(20));
    }
}

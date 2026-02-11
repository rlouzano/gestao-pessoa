package br.com.gestao.pessoa.web.controlers;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.entity.enums.DocumentType;
import br.com.gestao.pessoa.ports.in.web.DeletePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.in.web.GetPersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.in.web.SavePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.in.web.UpdatePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.web.requests.PersonManagementSystemRequest;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonManagementSystemControllerImpl.class)
public class PersonManagementSystemControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetPersonManagementSystemUseCasePort getPersonManagementSystemUseCasePort;

    @MockBean
    private SavePersonManagementSystemUseCasePort savePersonManagementSystemUseCasePort;

    @MockBean
    private UpdatePersonManagementSystemUseCasePort updatePersonManagementSystemUseCasePort;

    @MockBean
    private DeletePersonManagementSystemUseCasePort deletePersonManagementSystemUseCasePort;


    private static final String API_KEY = "test-key";
    private static final UUID CORRELATION_ID = UUID.randomUUID();

    private PersonManagementSystemDTO buildDto(Integer id) {
        PersonManagementSystemDTO dto = new PersonManagementSystemDTO();
        dto.setPersonSystemCode(id);
        dto.setPersonSystemName("Name " + id);
        dto.setDocumentSystemType(DocumentType.CPF);
        dto.setDocumentNumberSystem(123456789);
        dto.setPersonActiveIndicator(true);
        return dto;
    }

    @Test
    public void shouldReturnListOfPersons() throws Exception {
        List<PersonManagementSystemDTO> dtos = Arrays.asList(buildDto(1), buildDto(2));
        when(getPersonManagementSystemUseCasePort.getPersonManagementSystem()).thenReturn(dtos);

        mockMvc.perform(get("/api/persons")
                        .header("api_key", API_KEY)
                        .header("correlation_id", CORRELATION_ID.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].personSystemCode").value(1))
                .andExpect(jsonPath("$[0].personSystemName").value("Name 1"))
                .andExpect(jsonPath("$[1].personSystemCode").value(2));
    }

    @Test
    public void shouldReturnPersonById() throws Exception {
        PersonManagementSystemDTO dto = buildDto(5);
        when(getPersonManagementSystemUseCasePort.getPersonManagementSystemByIdPerson(eq(5))).thenReturn(dto);

        mockMvc.perform(get("/api/persons/5")
                        .header("api_key", API_KEY)
                        .header("correlation_id", CORRELATION_ID.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.personSystemCode").value(5))
                .andExpect(jsonPath("$.personSystemName").value("Name 5"));
    }

    @Test
    public void shouldCreatePerson() throws Exception {
        PersonManagementSystemRequest request = PersonManagementSystemRequest.builder()
                .personSystemName("New Name")
                .documentSystemType(DocumentType.CPF)
                .documentNumberSystem(987654321)
                .personActiveIndicator(true)
                .build();

        PersonManagementSystemDTO created = buildDto(10);
        when(savePersonManagementSystemUseCasePort.createPersonManagementSystemRequest(any(PersonManagementSystemRequest.class))).thenReturn(created);

        mockMvc.perform(post("/api/persons")
                        .header("api_key", API_KEY)
                        .header("correlation_id", CORRELATION_ID.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.personSystemCode").value(10))
                .andExpect(jsonPath("$.personSystemName").value("Name 10"));
    }

    @Test
    public void shouldUpdatePerson() throws Exception {
        PersonManagementSystemRequest request = PersonManagementSystemRequest.builder()
                .personSystemName("Updated")
                .build();

        PersonManagementSystemDTO updated = buildDto(15);
        when(updatePersonManagementSystemUseCasePort.updatePersonManagementSystem(eq(15), any(PersonManagementSystemRequest.class))).thenReturn(updated);

        mockMvc.perform(put("/api/persons/15")
                        .header("api_key", API_KEY)
                        .header("correlation_id", CORRELATION_ID.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.personSystemCode").value(15))
                .andExpect(jsonPath("$.personSystemName").value("Name 15"));
    }

    @Test
    public void shouldDeletePerson() throws Exception {
        // no need to stub for void

        mockMvc.perform(delete("/api/persons/20")
                        .header("api_key", API_KEY)
                        .header("correlation_id", CORRELATION_ID.toString()))
                .andExpect(status().isNoContent());

        verify(deletePersonManagementSystemUseCasePort, times(1)).deletePersonManagementSystem(eq(20));
    }
}

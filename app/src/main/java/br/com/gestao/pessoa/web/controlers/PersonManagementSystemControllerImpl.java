package br.com.gestao.pessoa.web.controlers;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.ports.in.web.DeletePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.in.web.GetPersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.in.web.SavePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.in.web.UpdatePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.web.mapper.PersonManagementSystemMapper;
import br.com.gestao.pessoa.web.requests.PersonManagementSystemRequest;
import br.com.gestao.pessoa.web.response.PersonManagementSystemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonManagementSystemControllerImpl implements PersonManagementSystemController {

    @Autowired
    private GetPersonManagementSystemUseCasePort getPersonManagementSystemUseCasePort;

    @Autowired
    private SavePersonManagementSystemUseCasePort savePersonManagementSystemUseCasePort;

    @Autowired
    private UpdatePersonManagementSystemUseCasePort updatePersonManagementSystemUseCasePort;

    @Autowired
    private DeletePersonManagementSystemUseCasePort deletePersonManagementSystemUseCasePort;

    @Override
    public ResponseEntity<List<PersonManagementSystemResponse>> getAllPersons(final String apiKey,
                                                                              final UUID correlationId) {
        List<PersonManagementSystemDTO> personManagementSystem =
                getPersonManagementSystemUseCasePort.getPersonManagementSystem();
        List<PersonManagementSystemResponse> personManagementSystemResponses =
                PersonManagementSystemMapper.INSTANCE.mapToResponse(personManagementSystem);
        return ResponseEntity.ok().body(personManagementSystemResponses);
    }

    @Override
    public ResponseEntity<PersonManagementSystemResponse> getPersonById(final Integer personId,
                                                                        final String apiKey,
                                                                        final UUID correlationId) {
        PersonManagementSystemDTO personManagementSystem =
                getPersonManagementSystemUseCasePort.getPersonManagementSystemByIdPerson(personId);
        PersonManagementSystemResponse personManagementSystemResponse =
                PersonManagementSystemMapper.INSTANCE.mapToResponse(personManagementSystem);
        return ResponseEntity.ok().body(personManagementSystemResponse);
    }

    @Override
    public ResponseEntity<PersonManagementSystemResponse> createPerson(final PersonManagementSystemRequest personManagementSystemRequest,
                                                                       final String apiKey,
                                                                       final UUID correlationId) {
        PersonManagementSystemDTO personRequest = savePersonManagementSystemUseCasePort.createPersonManagementSystemRequest(personManagementSystemRequest);
        PersonManagementSystemResponse personManagementSystemResponse =
                PersonManagementSystemMapper.INSTANCE.mapToResponse(personRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(personManagementSystemResponse);
    }

    @Override
    public ResponseEntity<PersonManagementSystemResponse> updatePerson(final Integer personId, final PersonManagementSystemRequest personManagementSystemRequest, final String apiKey, final UUID correlationId) {
        PersonManagementSystemDTO updated = updatePersonManagementSystemUseCasePort.updatePersonManagementSystem(personId, personManagementSystemRequest);
        PersonManagementSystemResponse response = PersonManagementSystemMapper.INSTANCE.mapToResponse(updated);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deletePerson(final Integer personId, final String apiKey, final UUID correlationId) {
        deletePersonManagementSystemUseCasePort.deletePersonManagementSystem(personId);
        return ResponseEntity.noContent().build();
    }

}

package br.com.gestao.pessoa.web.controlers;

import br.com.gestao.pessoa.web.requests.PersonManagementSystemRequest;
import br.com.gestao.pessoa.web.response.PersonManagementSystemResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/persons")
public interface PersonManagementSystemController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<PersonManagementSystemResponse>> getAllPersons(
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);

    @GetMapping("{person_id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PersonManagementSystemResponse> getPersonById(
            @PathVariable(value = "person_id") final Integer personId,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<PersonManagementSystemResponse> createPerson(
            @RequestBody final PersonManagementSystemRequest personManagementSystemRequest,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);

    @PutMapping("{person_id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PersonManagementSystemResponse> updatePerson(
            @PathVariable(value = "person_id") final Integer personId,
            @RequestBody final PersonManagementSystemRequest personManagementSystemRequest,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);

    @DeleteMapping("{person_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deletePerson(
            @PathVariable(value = "person_id") final Integer personId,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);
}

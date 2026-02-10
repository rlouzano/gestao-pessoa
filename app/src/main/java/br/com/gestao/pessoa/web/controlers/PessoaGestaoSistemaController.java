package br.com.gestao.pessoa.web.controlers;

import br.com.gestao.pessoa.web.requests.PessoaGestaoSistemaRequest;
import br.com.gestao.pessoa.web.response.PessoaGestaoSistemaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/gestao")
public interface PessoaGestaoSistemaController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<PessoaGestaoSistemaResponse>> buscaTodosFuncionarios(
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);

    @GetMapping("{id_pessoa}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PessoaGestaoSistemaResponse> getBuscaFuncionarioPorIdPessoa(
            @PathVariable(value = "id_pessoa") final Integer idPessoa,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<PessoaGestaoSistemaResponse> createFuncionario(
            @RequestBody final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);

    @PutMapping("{id_pessoa}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PessoaGestaoSistemaResponse> updatedFuncionario(
            @PathVariable(value = "id_pessoa") final Integer idPessoa,
            @RequestBody final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);

    @DeleteMapping("{id_pessoa}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deleteFuncionario(
            @PathVariable(value = "id_pessoa") final Integer idPessoa,
            @RequestHeader(value = "api_key") final String apiKey,
            @RequestHeader(value = "currelation_id") final UUID correlationId);
}

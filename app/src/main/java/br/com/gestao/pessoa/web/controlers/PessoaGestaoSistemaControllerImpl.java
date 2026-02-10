package br.com.gestao.pessoa.web.controlers;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.ports.in.web.AtualizarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.in.web.DeletarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.in.web.GetPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.in.web.SalvarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.web.requests.PessoaGestaoSistemaRequest;
import br.com.gestao.pessoa.web.response.PessoaGestaoSistemaResponse;
import br.com.gestao.pessoa.web.mapper.PessoaGestaoSistemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PessoaGestaoSistemaControllerImpl implements PessoaGestaoSistemaController{

    @Autowired
    private GetPessoaGestaoSistemaUseCasePort getPessoaGestaoSistemaUseCasePort;

    @Autowired
    private SalvarPessoaGestaoSistemaUseCasePort salvarPessoaGestaoSistemaUseCasePort;

    @Autowired
    private AtualizarPessoaGestaoSistemaUseCasePort atualizarPessoaGestaoSistemaUseCasePort;

    @Autowired
    private DeletarPessoaGestaoSistemaUseCasePort deletarPessoaGestaoSistemaUseCasePort;

    @Override
    public ResponseEntity<List<PessoaGestaoSistemaResponse>> buscaTodosFuncionarios(final String apiKey,
                                                                                    final UUID correlationId) {
        List<PessoaGestaoSistemaDTO> pessoaGestaoSistema =
                getPessoaGestaoSistemaUseCasePort.getPessoaGestaoSistema();
        List<PessoaGestaoSistemaResponse> pessoaGestaoSistemaResponses =
                PessoaGestaoSistemaMapper.INSTANCE.mapToResponse(pessoaGestaoSistema);
        return ResponseEntity.ok().body(pessoaGestaoSistemaResponses);
    }

    @Override
    public ResponseEntity<PessoaGestaoSistemaResponse> getBuscaFuncionarioPorIdPessoa(final Integer idPessoa,
                                                                                      final String apiKey,
                                                                                      final UUID correlationId) {
        PessoaGestaoSistemaDTO pessoaGestaoSistema =
                getPessoaGestaoSistemaUseCasePort.getPessoaGestaoSistemaPorIdPessoa(idPessoa);
        PessoaGestaoSistemaResponse pessoaGestaoSistemaResponses =
                PessoaGestaoSistemaMapper.INSTANCE.mapToResponse(pessoaGestaoSistema);
        return ResponseEntity.ok().body(pessoaGestaoSistemaResponses);
    }

    @Override
    public ResponseEntity<PessoaGestaoSistemaResponse> createFuncionario(final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest,
                                                                         final String apiKey,
                                                                         final UUID correlationId) {
        PessoaGestaoSistemaDTO pessoaGestaoSistemaRequest1 = salvarPessoaGestaoSistemaUseCasePort.createPessoaGestaoSistemaRequest(pessoaGestaoSistemaRequest);
        PessoaGestaoSistemaResponse pessoaGestaoSistemaResponses =
                PessoaGestaoSistemaMapper.INSTANCE.mapToResponse(pessoaGestaoSistemaRequest1);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaGestaoSistemaResponses);
    }

    @Override
    public ResponseEntity<PessoaGestaoSistemaResponse> updatedFuncionario(final Integer idPessoa, final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest, final String apiKey, final UUID correlationId) {
        PessoaGestaoSistemaDTO updated = atualizarPessoaGestaoSistemaUseCasePort.updatePessoaGestaoSistema(idPessoa, pessoaGestaoSistemaRequest);
        PessoaGestaoSistemaResponse response = PessoaGestaoSistemaMapper.INSTANCE.mapToResponse(updated);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> deleteFuncionario(final Integer idPessoa, final String apiKey, final UUID correlationId) {
        deletarPessoaGestaoSistemaUseCasePort.deletePessoaGestaoSistema(idPessoa);
        return ResponseEntity.noContent().build();
    }

}

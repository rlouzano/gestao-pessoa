package br.com.gestao.pessoa.web;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.ports.in.web.GetPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.web.dto.response.PessoaGestaoSistemaResponse;
import br.com.gestao.pessoa.web.mapper.PessoaGestaoSistemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/gestao")
public class PessoaGestaoSistemaController {

    @Autowired
    private GetPessoaGestaoSistemaUseCasePort getPessoaGestaoSistemaUseCasePort;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity buscaTodosFuncionarios() {
        List<PessoaGestaoSistemaDTO> pessoaGestaoSistema =
                getPessoaGestaoSistemaUseCasePort.getPessoaGestaoSistema();
        List<PessoaGestaoSistemaResponse> pessoaGestaoSistemaResponses =
                PessoaGestaoSistemaMapper.INSTANCE.mapToResponse(pessoaGestaoSistema);
        return ResponseEntity.ok().body(pessoaGestaoSistemaResponses);
    }
}

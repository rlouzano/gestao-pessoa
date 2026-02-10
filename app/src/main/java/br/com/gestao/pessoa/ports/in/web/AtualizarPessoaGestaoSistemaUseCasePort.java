package br.com.gestao.pessoa.ports.in.web;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.web.requests.PessoaGestaoSistemaRequest;

public interface AtualizarPessoaGestaoSistemaUseCasePort {

    PessoaGestaoSistemaDTO updatePessoaGestaoSistema(final Integer idPessoa, final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest);
}


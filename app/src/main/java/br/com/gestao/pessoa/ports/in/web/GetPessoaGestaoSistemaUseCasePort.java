package br.com.gestao.pessoa.ports.in.web;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;

import java.util.List;

public interface GetPessoaGestaoSistemaUseCasePort {

    List<PessoaGestaoSistemaDTO> getPessoaGestaoSistema();

    PessoaGestaoSistemaDTO getPessoaGestaoSistemaPorIdPessoa(final Integer idPessoa);
}

package br.com.gestao.pessoa.ports.out.persistence;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;

import java.util.List;
import java.util.Optional;

public interface PessoaGestaoSistemaUseCase {

    List<PessoaGestaoSistemaEntity> getBuscaTodosFuncionariosPessoaGestaoSistema();

    PessoaGestaoSistemaEntity getBuscaFuncionarioPorId0PessoaGestaoSistema(final Integer idPessoa);

    PessoaGestaoSistemaEntity createFuncionarioPessoaGestaoSistema(final PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity);

    PessoaGestaoSistemaEntity updateFuncionarioPessoaGestaoSistema(final PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity);

    PessoaGestaoSistemaEntity deleteFuncionarioPessoaGestaoSistema(final PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity);
}

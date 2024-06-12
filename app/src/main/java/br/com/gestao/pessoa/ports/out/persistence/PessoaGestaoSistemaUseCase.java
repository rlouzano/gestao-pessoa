package br.com.gestao.pessoa.ports.out.persistence;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;

import java.util.List;

public interface PessoaGestaoSistemaUseCase {

    List<PessoaGestaoSistemaEntity> getPessoaGestaoSistema();

}

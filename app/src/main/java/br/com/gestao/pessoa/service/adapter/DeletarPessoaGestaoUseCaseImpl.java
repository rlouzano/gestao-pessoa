package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.ports.in.web.DeletarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PessoaGestaoSistemaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarPessoaGestaoUseCaseImpl implements DeletarPessoaGestaoSistemaUseCasePort {

    @Autowired
    private PessoaGestaoSistemaUseCase pessoaGestaoSistemaUseCase;

    @Override
    public void deletePessoaGestaoSistema(final Integer idPessoa) {
        PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity = new PessoaGestaoSistemaEntity();
        pessoaGestaoSistemaEntity.setCodigoPessoaSistema(idPessoa);
        pessoaGestaoSistemaUseCase.deleteFuncionarioPessoaGestaoSistema(pessoaGestaoSistemaEntity);
    }
}


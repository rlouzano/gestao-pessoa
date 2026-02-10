package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.ports.in.web.AtualizarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PessoaGestaoSistemaUseCase;
import br.com.gestao.pessoa.service.mapper.PessoGestaoSistemaMapper;
import br.com.gestao.pessoa.service.mapper.AtualizarPessoaGestaoMapper;
import br.com.gestao.pessoa.web.requests.PessoaGestaoSistemaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPessoaGestaoUseCaseImpl implements AtualizarPessoaGestaoSistemaUseCasePort {

    @Autowired
    private PessoaGestaoSistemaUseCase pessoaGestaoSistemaUseCase;

    @Override
    public PessoaGestaoSistemaDTO updatePessoaGestaoSistema(final Integer idPessoa, final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest) {
        PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity =
                AtualizarPessoaGestaoMapper.INSTANCE.mapToEntity(pessoaGestaoSistemaRequest);
        pessoaGestaoSistemaEntity.setCodigoPessoaSistema(idPessoa);
        PessoaGestaoSistemaEntity updateFuncionarioPessoaGestaoSistema =
                pessoaGestaoSistemaUseCase.updateFuncionarioPessoaGestaoSistema(pessoaGestaoSistemaEntity);
        return PessoGestaoSistemaMapper.INSTANCE.mapToDto(updateFuncionarioPessoaGestaoSistema);
    }
}

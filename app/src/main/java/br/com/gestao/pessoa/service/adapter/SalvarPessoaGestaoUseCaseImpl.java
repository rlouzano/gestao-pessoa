package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.ports.in.web.SalvarPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PessoaGestaoSistemaUseCase;
import br.com.gestao.pessoa.service.mapper.PessoGestaoSistemaMapper;
import br.com.gestao.pessoa.service.mapper.SalvarPessoaGestaoMapper;
import br.com.gestao.pessoa.web.requests.PessoaGestaoSistemaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarPessoaGestaoUseCaseImpl implements SalvarPessoaGestaoSistemaUseCasePort {

    @Autowired
    private PessoaGestaoSistemaUseCase pessoaGestaoSistemaUseCase;


    @Override
    public PessoaGestaoSistemaDTO createPessoaGestaoSistemaRequest(final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest) {
        PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity =
                SalvarPessoaGestaoMapper.INSTANCE.mapToDto(pessoaGestaoSistemaRequest);
        PessoaGestaoSistemaEntity funcionarioPessoaGestaoSistema =
                pessoaGestaoSistemaUseCase.createFuncionarioPessoaGestaoSistema(pessoaGestaoSistemaEntity);
        return PessoGestaoSistemaMapper.INSTANCE.mapToDto(funcionarioPessoaGestaoSistema);
    }
}

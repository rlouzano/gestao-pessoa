package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.ports.in.web.GetPessoaGestaoSistemaUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PessoaGestaoSistemaUseCase;
import br.com.gestao.pessoa.service.mapper.PessoGestaoSistemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPessoaGestaoUseCaseImpl implements GetPessoaGestaoSistemaUseCasePort {

    @Autowired
    private PessoaGestaoSistemaUseCase pessoaGestaoSistemaUseCase;

    @Override
    public List<PessoaGestaoSistemaDTO> getPessoaGestaoSistema() {
        List<PessoaGestaoSistemaEntity> pessoaGestaoSistemaEntities =
                pessoaGestaoSistemaUseCase.getBuscaTodosFuncionariosPessoaGestaoSistema();
        return PessoGestaoSistemaMapper.INSTANCE.mapToDto(pessoaGestaoSistemaEntities);
    }

    @Override
    public PessoaGestaoSistemaDTO getPessoaGestaoSistemaPorIdPessoa(final Integer idPessoa) {
        PessoaGestaoSistemaEntity pessoaGestaoSistemaEntities =
                pessoaGestaoSistemaUseCase.getBuscaFuncionarioPorId0PessoaGestaoSistema(idPessoa);
        return PessoGestaoSistemaMapper.INSTANCE.mapToDto(pessoaGestaoSistemaEntities);
    }
}

package br.com.gestao.pessoa.infra.adapter;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.exception.Response404Exception;
import br.com.gestao.pessoa.infra.mapper.PessoaGestaoMapper;
import br.com.gestao.pessoa.infra.repository.PessoaGestaoSistemaRepository;
import br.com.gestao.pessoa.ports.out.persistence.PessoaGestaoSistemaUseCase;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaGestaoUseCaseImpl implements PessoaGestaoSistemaUseCase {

    @Autowired
    private PessoaGestaoSistemaRepository pessoaGestaoSistemaRepository;

    @Override
    public List<PessoaGestaoSistemaEntity> getBuscaTodosFuncionariosPessoaGestaoSistema() {
        List<PessoaGestaoSistemaEntity> pessoaGestaoSistemaEntities =
                pessoaGestaoSistemaRepository.findAllPessoas();
        if (CollectionUtils.isNotEmpty(pessoaGestaoSistemaEntities)) {
            return pessoaGestaoSistemaEntities;
        }
        throw new Response404Exception("List of people not found.");
    }

    @Override
    public PessoaGestaoSistemaEntity getBuscaFuncionarioPorId0PessoaGestaoSistema(final Integer idPessoa) {
        return pessoaGestaoSistemaRepository.findByIdPessoa(idPessoa)
                .orElseThrow(() -> new Response404Exception("People not found."));
    }

    @Override
    public PessoaGestaoSistemaEntity createFuncionarioPessoaGestaoSistema(final PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity) {
        return pessoaGestaoSistemaRepository.save(pessoaGestaoSistemaEntity);
    }


    @Override
    public PessoaGestaoSistemaEntity updateFuncionarioPessoaGestaoSistema(
            final PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity) {
        return pessoaGestaoSistemaRepository.findByIdPessoa(pessoaGestaoSistemaEntity.getCodigoPessoaSistema())
                .map(pessoaExistente -> {
                    PessoaGestaoMapper.INSTANCE.updatePessoaFromEntity(pessoaGestaoSistemaEntity, pessoaExistente);
                    return pessoaGestaoSistemaRepository.save(pessoaExistente);
                })
                .orElseThrow(() -> new Response404Exception("People not found."));
    }

    @Override
    public PessoaGestaoSistemaEntity deleteFuncionarioPessoaGestaoSistema(
            final PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity) {
        return pessoaGestaoSistemaRepository.findByIdPessoa(pessoaGestaoSistemaEntity.getCodigoPessoaSistema())
                .map(pessoaExistente -> {
                    PessoaGestaoMapper.INSTANCE.deletePessoaLogica(pessoaGestaoSistemaEntity,pessoaExistente);
                    return pessoaGestaoSistemaRepository.save(pessoaExistente);
                })
                .orElseThrow(() -> new Response404Exception("People not found."));
    }


}

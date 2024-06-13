package br.com.gestao.pessoa.infra.adapter;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.exception.Response404Exception;
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
    public List<PessoaGestaoSistemaEntity> getPessoaGestaoSistema() {
        List<PessoaGestaoSistemaEntity> pessoaGestaoSistemaEntities = pessoaGestaoSistemaRepository.findAll();
        if (CollectionUtils.isNotEmpty(pessoaGestaoSistemaEntities)) {
            return pessoaGestaoSistemaEntities;
        }
        throw new Response404Exception("List of people not found.");
    }
}

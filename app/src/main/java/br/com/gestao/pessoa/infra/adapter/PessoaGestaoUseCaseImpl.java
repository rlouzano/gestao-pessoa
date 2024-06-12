package br.com.gestao.pessoa.infra.adapter;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.infra.repository.PessoaGestaoSistemaRepository;
import br.com.gestao.pessoa.ports.out.persistence.PessoaGestaoSistemaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaGestaoUseCaseImpl implements PessoaGestaoSistemaUseCase {

    @Autowired
    private PessoaGestaoSistemaRepository pessoaGestaoSistemaRepository;
    @Override
    public List<PessoaGestaoSistemaEntity> getPessoaGestaoSistema() {
        return pessoaGestaoSistemaRepository.findAll();
    }
}

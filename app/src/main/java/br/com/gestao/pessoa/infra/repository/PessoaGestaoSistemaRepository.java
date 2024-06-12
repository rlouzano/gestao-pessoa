package br.com.gestao.pessoa.infra.repository;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaGestaoSistemaRepository extends JpaRepository<PessoaGestaoSistemaEntity, Integer> {

}

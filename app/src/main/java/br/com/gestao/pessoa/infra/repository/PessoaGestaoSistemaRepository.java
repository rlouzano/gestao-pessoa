package br.com.gestao.pessoa.infra.repository;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaGestaoSistemaRepository extends JpaRepository<PessoaGestaoSistemaEntity, Integer> {

    String FIND_ALL = "SELECT pessoaGestaoSistema FROM PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity " +
            "WHERE pessoaGestaoSistemaEntity.indicadorPessoaAtiva is true";

    String FINDY_BY_ID_PESSOA = "SELECT pessoaGestaoSistema FROM PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity " +
            "WHERE pessoaGestaoSistemaEntity.codigoPessoaSistema = :idPessoa " +
            "AND pessoaGestaoSistemaEntity.indicadorPessoaAtiva is true";


    @Query(value = FIND_ALL)
    List<PessoaGestaoSistemaEntity> findAllPessoas();

    @Query(value = FINDY_BY_ID_PESSOA)
    Optional<PessoaGestaoSistemaEntity> findByIdPessoa(final Integer idPessoa);
}

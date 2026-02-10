package br.com.gestao.pessoa.entity;

import br.com.gestao.pessoa.entity.enums.TipoDocumentoSistema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class PessoaGestaoSistemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoPessoaSistema;
    private String nomePessoaSistema;
    private TipoDocumentoSistema tipoDocumentoSistema;
    private Integer numeroDocumentoSistema;
    private LocalDate dataAdminssao;
    private LocalDate dataDesligamento;
    private Boolean indicadorPessoaAtiva;
    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;

    @OneToMany(mappedBy = "pessoaGestaoSistemaEntity", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @Where(clause = "indicadorCargoAtivo=1")
    private List<CargoGestaoSistemaEntity> cargoGestaoSistemaEntity;

    @OneToMany(mappedBy = "pessoaGestaoSistemaEntity", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    @Where(clause = "indicadorSalarioAtivo=1")
    private List<SalarioPessoaGestaoSistemaEntity> salarioPessoaSistema;
}

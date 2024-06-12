package br.com.gestao.pessoa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class SalarioPessoaGestaoSistemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoSalarioPessoaSistema;
    private BigDecimal valorSalarioPessoaSistema;
    private Boolean indicadorSalarioAtivo;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity;
    private LocalDate dataInicioSalario;
    private LocalDate dataFimSalario;
}

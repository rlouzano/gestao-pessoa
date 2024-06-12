package br.com.gestao.pessoa.domain.dto;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalarioPessoaGestaoSistemaDTO {

    private Integer codigoSalarioPessoaSistema;
    private BigDecimal valorSalarioPessoaSistema;
    private Boolean indicadorSalarioAtivo;
    private PessoaGestaoSistemaDTO pessoaGestaoSistemaDTO;
}

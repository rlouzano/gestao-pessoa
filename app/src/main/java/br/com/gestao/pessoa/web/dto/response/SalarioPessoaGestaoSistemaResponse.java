package br.com.gestao.pessoa.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalarioPessoaGestaoSistemaResponse {

    private Integer codigoSalarioPessoaSistema;
    private BigDecimal valorSalarioPessoaSistema;
    private Boolean indicadorSalarioAtivo;
    private PessoaGestaoSistemaResponse pessoaGestaoSistemaResponse;
}

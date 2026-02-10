package br.com.gestao.pessoa.web.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoGestaoSistemaResponse {

    private Integer codigoCargoGestaoSistema;
    private String nomeCargoGestaoSistema;
    private Boolean indicadorCargoAtivo;
    private PessoaGestaoSistemaResponse pessoaGestaoSistemaResponse;
}

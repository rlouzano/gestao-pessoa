package br.com.gestao.pessoa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoGestaoSistemaDTO {

    private Integer codigoCargoGestaoSistema;
    private String nomeCargoGestaoSistema;
    private Boolean indicadorCargoAtivo;
    private PessoaGestaoSistemaDTO pessoaGestaoSistemaDTO;
}

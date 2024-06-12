package br.com.gestao.pessoa.domain.dto;

import br.com.gestao.pessoa.entity.enums.TipoDocumentoSistema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PessoaGestaoSistemaDTO {

    private Integer codigoPessoaSistema;
    private String nomePessoaSistema;
    private TipoDocumentoSistema tipoDocumentoSistema;
    private Integer numeroDocumentoSistema;
    private Boolean indicadorPessoaAtiva;

    private List<CargoGestaoSistemaDTO> cargoGestaoSistemaDTO;

    private List<SalarioPessoaGestaoSistemaDTO> salarioPessoaGestaoSistemaDTO;
}

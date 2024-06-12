package br.com.gestao.pessoa.web.dto.response;

import br.com.gestao.pessoa.entity.enums.TipoDocumentoSistema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PessoaGestaoSistemaResponse {

    private Integer codigoPessoaSistema;
    private String nomePessoaSistema;
    private TipoDocumentoSistema tipoDocumentoSistema;
    private Integer numeroDocumentoSistema;
    private Boolean indicadorPessoaAtiva;

    private List<CargoGestaoSistemaResponse> cargoGestaoSistemaResponse;

    private List<SalarioPessoaGestaoSistemaResponse> salarioPessoaGestaoSistemaResponse;
}

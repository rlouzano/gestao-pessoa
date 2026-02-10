package br.com.gestao.pessoa.web.requests;

import br.com.gestao.pessoa.entity.enums.TipoDocumentoSistema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PessoaGestaoSistemaRequest {

    private String nomePessoaSistema;
    private TipoDocumentoSistema tipoDocumentoSistema;
    private Integer numeroDocumentoSistema;
    private Boolean indicadorPessoaAtiva;
}

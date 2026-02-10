package br.com.gestao.pessoa.domain.dto;

import br.com.gestao.pessoa.entity.enums.TipoDocumentoSistema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Getter
@Setter
public class PessoaGestaoSistemaDTO {

    private Integer codigoPessoaSistema;
    private String nomePessoaSistema;
    private TipoDocumentoSistema tipoDocumentoSistema;
    private Integer numeroDocumentoSistema;
    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;
    private Boolean indicadorPessoaAtiva;

    private List<CargoGestaoSistemaDTO> cargoGestaoSistemaDTO;

    private List<SalarioPessoaGestaoSistemaDTO> salarioPessoaGestaoSistemaDTO;
}

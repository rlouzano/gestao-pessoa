package br.com.gestao.pessoa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class CargoGestaoSistemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCargoGestaoSistema;
    private String nomeCargoGestaoSistema;
    private Boolean indicadorCargoAtivo;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity;
    private LocalDate dataInicioCargo;
    private LocalDate dataFimCargo;

}

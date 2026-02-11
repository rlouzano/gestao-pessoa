package br.com.gestao.pessoa.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionManagementSystemDTO {

    private Integer positionSystemCode;
    private String positionSystemName;
    private Boolean positionActiveIndicator;
    private PersonManagementSystemDTO personManagementSystemDTO;
}

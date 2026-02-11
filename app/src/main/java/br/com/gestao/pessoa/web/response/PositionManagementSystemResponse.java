package br.com.gestao.pessoa.web.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionManagementSystemResponse {

    private Integer positionSystemCode;
    private String positionSystemName;
    private Boolean positionActiveIndicator;
    private PersonManagementSystemResponse personManagementSystemResponse;
}

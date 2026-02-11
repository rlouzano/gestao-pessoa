package br.com.gestao.pessoa.web.response;

import br.com.gestao.pessoa.entity.enums.DocumentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PersonManagementSystemResponse {

    private Integer personSystemCode;
    private String personSystemName;
    private DocumentType documentSystemType;
    private Integer documentNumberSystem;
    private Boolean personActiveIndicator;
    private LocalDate admissionDate;

    private List<PositionManagementSystemResponse> positionManagementSystemResponse;

    private List<SalaryPersonManagementSystemResponse> salaryPersonManagementSystemResponse;
}

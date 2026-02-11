package br.com.gestao.pessoa.domain.dto;

import br.com.gestao.pessoa.entity.enums.DocumentType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PersonManagementSystemDTO {

    private Integer personSystemCode;
    private String personSystemName;
    private DocumentType documentSystemType;
    private Integer documentNumberSystem;
    private LocalDate admissionDate;
    private LocalDate inclusionDate;
    private LocalDate updateDate;
    private Boolean personActiveIndicator;

    private List<PositionManagementSystemDTO> positionManagementSystemDTO;

    private List<SalaryPersonManagementSystemDTO> salaryPersonManagementSystemDTO;
}

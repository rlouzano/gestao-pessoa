package br.com.gestao.pessoa.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryPersonManagementSystemDTO {

    private Integer salaryPersonSystemCode;
    private BigDecimal salaryPersonSystemValue;
    private Boolean salaryActiveIndicator;
    private PersonManagementSystemDTO personManagementSystemDTO;
}

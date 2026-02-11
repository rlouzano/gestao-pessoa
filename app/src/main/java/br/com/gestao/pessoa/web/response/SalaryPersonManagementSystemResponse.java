package br.com.gestao.pessoa.web.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryPersonManagementSystemResponse {

    private Integer salaryPersonSystemCode;
    private BigDecimal salaryPersonSystemValue;
    private Boolean salaryActiveIndicator;
    private PersonManagementSystemResponse personManagementSystemResponse;
}

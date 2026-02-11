package br.com.gestao.pessoa.web.requests;

import br.com.gestao.pessoa.entity.enums.DocumentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PersonManagementSystemRequest {

    private String personSystemName;
    private DocumentType documentSystemType;
    private Integer documentNumberSystem;
    private LocalDate admissionDate;
    private Boolean personActiveIndicator;
}

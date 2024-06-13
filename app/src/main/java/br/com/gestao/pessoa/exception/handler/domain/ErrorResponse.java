package br.com.gestao.pessoa.exception.handler.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorField> errors;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorField {
        private String code;
        private String field;
        private String message;
    }
}

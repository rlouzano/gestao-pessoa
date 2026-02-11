package br.com.gestao.pessoa.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {

    CPF(1),
    FOREIGN(2);

    private final Integer value;

    public static DocumentType getByName(String enumName) {
        for (DocumentType documentType : DocumentType.values()) {
            if (documentType.toString().equals(enumName)) {
                return documentType;
            }
        }
        return null;
    }

    public static DocumentType getByValue(Integer value){
        for (DocumentType documentType : DocumentType.values()){
            if(documentType.getValue().equals(value)){
                return documentType;
            }
        }
        return null;
    }
}

package br.com.gestao.pessoa.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDocumentoSistema {

    CPF(1),
    ESTRANGEIRO(2);

    private final Integer value;

    public static TipoDocumentoSistema getByName(String nomeEnum) {
        for (TipoDocumentoSistema tipoDocumentoSistema : TipoDocumentoSistema.values()) {
            if (tipoDocumentoSistema.toString().equals(nomeEnum)) {
                return tipoDocumentoSistema;
            }
        }
        return null;
    }

    public static TipoDocumentoSistema getByValue(Integer valor){
        for (TipoDocumentoSistema tipoDocumentoSistema : TipoDocumentoSistema.values()){
            if(tipoDocumentoSistema.getValue().equals(valor)){
                return tipoDocumentoSistema;
            }
        }
        return null;
    }
}

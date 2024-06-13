package br.com.gestao.pessoa.exception.handler.mapper;

import br.com.gestao.pessoa.exception.handler.domain.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.lang.reflect.Field;

public class ErrorResponseMapper {

    private final ObjectMapper mapper;

    public ErrorResponseMapper() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ErrorResponse getErrorResponse(final String message) {
        try {
            return mapper.readValue(message, ErrorResponse.class);
        } catch (final Exception e) {
            return new ErrorResponse(message, null);
        }
    }

    public String getJsonName(final Class<?> errorModelClass, final String fieldName) {
        try {
            final String[] fieldList = fieldName.split("\\.");
            final Field field = errorModelClass.getDeclaredField(fieldList[0]);
            final JsonProperty jsonProperty = field.getDeclaredAnnotation(JsonProperty.class);
            String returnField = jsonProperty.value();
            if (fieldList.length > 1) {
                final String innerField = getJsonName(field.getType(), fieldName.substring(fieldName.indexOf(".") + 1));
                returnField = jsonProperty.value().concat(".").concat(innerField);
            }
            return returnField;
        } catch (final Exception e) {
            return fieldName;
        }
    }
}

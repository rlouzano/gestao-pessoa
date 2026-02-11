package br.com.gestao.pessoa.service.mapper;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.web.requests.PersonManagementSystemRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class UpdatePersonManagementSystemMapper {

    public static final UpdatePersonManagementSystemMapper INSTANCE = Mappers.getMapper(UpdatePersonManagementSystemMapper.class);

    @Mapping(target = "updateDate", expression = "java(java.time.LocalDate.now())")
    public abstract PersonManagementSystemEntity mapToEntity(final PersonManagementSystemRequest request);
}


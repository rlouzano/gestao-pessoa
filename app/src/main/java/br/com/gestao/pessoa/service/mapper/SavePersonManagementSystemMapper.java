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
public abstract class SavePersonManagementSystemMapper {

    public static final SavePersonManagementSystemMapper INSTANCE = Mappers.getMapper(SavePersonManagementSystemMapper.class);

    @Mapping(target = "updateDate", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "inclusionDate", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "personActiveIndicator", constant = "true")
    public abstract PersonManagementSystemEntity mapToDto(final PersonManagementSystemRequest personManagementSystemRequest);

}

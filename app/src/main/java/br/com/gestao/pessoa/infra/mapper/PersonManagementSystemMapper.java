package br.com.gestao.pessoa.infra.mapper;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PersonManagementSystemMapper {

    public static final PersonManagementSystemMapper INSTANCE = Mappers.getMapper(PersonManagementSystemMapper.class);

    @Mapping(target = "personSystemCode", ignore = true)
    @Mapping(target = "inclusionDate", ignore = true)
    @Mapping(target = "updateDate", expression = "java(java.time.LocalDate.now())")
    public abstract void updatePersonFromEntity(PersonManagementSystemEntity source, @MappingTarget PersonManagementSystemEntity target);

    @Mapping(target = "personActiveIndicator", constant = "false")
    @Mapping(target = "terminationDate", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "updateDate", expression = "java(java.time.LocalDate.now())")
    public abstract void deletePersonLogical(PersonManagementSystemEntity source, @MappingTarget PersonManagementSystemEntity target);

}

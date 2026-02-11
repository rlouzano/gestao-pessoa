package br.com.gestao.pessoa.service.mapper;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PersonManagementSystemMapper {
    public static final PersonManagementSystemMapper INSTANCE = Mappers.getMapper(PersonManagementSystemMapper.class);
    public abstract List<PersonManagementSystemDTO> mapToDto(final List<PersonManagementSystemEntity> personManagementSystemEntities);
    public abstract PersonManagementSystemDTO mapToDto(final PersonManagementSystemEntity personManagementSystemEntity);
}

package br.com.gestao.pessoa.web.mapper;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.web.response.PersonManagementSystemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PersonManagementSystemMapper {

    public static final PersonManagementSystemMapper INSTANCE = Mappers.getMapper(PersonManagementSystemMapper.class);
    public abstract List<PersonManagementSystemResponse> mapToResponse(final List<PersonManagementSystemDTO> personManagementSystemDTOs);
    public abstract PersonManagementSystemResponse mapToResponse(final PersonManagementSystemDTO personManagementSystemDTO);

}

package br.com.gestao.pessoa.service.mapper;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PessoGestaoSistemaMapper {
    public static final PessoGestaoSistemaMapper INSTANCE = Mappers.getMapper(PessoGestaoSistemaMapper.class);
    public abstract List<PessoaGestaoSistemaDTO> mapToDto(final List<PessoaGestaoSistemaEntity> pessoaGestaoSistemaEntities);
    public abstract PessoaGestaoSistemaDTO mapToDto(final PessoaGestaoSistemaEntity pessoaGestaoSistemaEntity);

}

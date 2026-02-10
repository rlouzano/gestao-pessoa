package br.com.gestao.pessoa.web.mapper;

import br.com.gestao.pessoa.domain.dto.PessoaGestaoSistemaDTO;
import br.com.gestao.pessoa.web.response.PessoaGestaoSistemaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PessoaGestaoSistemaMapper {

    public static final PessoaGestaoSistemaMapper INSTANCE = Mappers.getMapper(PessoaGestaoSistemaMapper.class);
    public abstract List<PessoaGestaoSistemaResponse> mapToResponse(final List<PessoaGestaoSistemaDTO> pessoaGestaoSistemaDTOS);
    public abstract PessoaGestaoSistemaResponse mapToResponse(final PessoaGestaoSistemaDTO pessoaGestaoSistemaDTO);

}

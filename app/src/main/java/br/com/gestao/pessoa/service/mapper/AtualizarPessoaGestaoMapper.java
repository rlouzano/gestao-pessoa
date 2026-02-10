package br.com.gestao.pessoa.service.mapper;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.web.requests.PessoaGestaoSistemaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class AtualizarPessoaGestaoMapper {

    public static final AtualizarPessoaGestaoMapper INSTANCE = Mappers.getMapper(AtualizarPessoaGestaoMapper.class);

    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDate.now())")
    public abstract PessoaGestaoSistemaEntity mapToEntity(final PessoaGestaoSistemaRequest request);
}


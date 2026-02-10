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
public abstract class SalvarPessoaGestaoMapper {

    public static final SalvarPessoaGestaoMapper INSTANCE = Mappers.getMapper(SalvarPessoaGestaoMapper.class);

    @Mapping(target = "dataAtualizacao", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "dataInclusao", expression = "java(java.time.LocalDate.now())")
    @Mapping(target = "indicadorPessoaAtiva", constant = "true")
    public abstract PessoaGestaoSistemaEntity mapToDto(final PessoaGestaoSistemaRequest pessoaGestaoSistemaRequest);

}

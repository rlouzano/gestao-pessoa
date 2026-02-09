package br.com.gestao.pessoa.infra.mapper;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class PessoaGestaoMapper {

    public static final PessoaGestaoMapper INSTANCE = Mappers.getMapper(PessoaGestaoMapper.class);

    public abstract void updatePessoaFromEntity(PessoaGestaoSistemaEntity source, @MappingTarget PessoaGestaoSistemaEntity target);


    @Mapping(target = "indicadorPessoaAtiva", constant = "false")
    @Mapping(target = "dataDesligamento", expression = "java(java.time.LocalDate.now())")
    public abstract PessoaGestaoSistemaEntity deletePessoaLogica(@MappingTarget PessoaGestaoSistemaEntity target);
}

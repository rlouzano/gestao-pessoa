package br.com.gestao.pessoa.infra.mapper;

import br.com.gestao.pessoa.entity.PessoaGestaoSistemaEntity;
import br.com.gestao.pessoa.entity.enums.TipoDocumentoSistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaGestaoMapperTest {

    private PessoaGestaoSistemaEntity existingPessoa;
    private PessoaGestaoSistemaEntity updateSource;

    @BeforeEach
    public void setUp() {
        // Setup entity já existente no banco de dados
        existingPessoa = new PessoaGestaoSistemaEntity();
        existingPessoa.setCodigoPessoaSistema(1);
        existingPessoa.setNomePessoaSistema("Nome Original");
        existingPessoa.setTipoDocumentoSistema(TipoDocumentoSistema.CPF);
        existingPessoa.setNumeroDocumentoSistema(123456789);
        existingPessoa.setDataInclusao(LocalDate.of(2024, 1, 1));
        existingPessoa.setDataAtualizacao(LocalDate.of(2024, 1, 1));
        existingPessoa.setIndicadorPessoaAtiva(true);

        // Setup entity com dados parciais para atualização
        updateSource = new PessoaGestaoSistemaEntity();
        updateSource.setCodigoPessoaSistema(999); // deve ser ignorado
        updateSource.setNomePessoaSistema("Nome Atualizado");
        // outros campos nulos = devem ser ignorados
    }

    @Test
    public void testUpdatePessoaFromEntityPartialUpdate() {
        LocalDate dataBefore = existingPessoa.getDataAtualizacao();

        // Aplicar atualização
        PessoaGestaoMapper.INSTANCE.updatePessoaFromEntity(updateSource, existingPessoa);

        // Validações
        assertEquals(1, existingPessoa.getCodigoPessoaSistema(), "codigoPessoaSistema deve ser ignorado");
        assertEquals("Nome Atualizado", existingPessoa.getNomePessoaSistema(), "nome deve ser atualizado");
        assertEquals(TipoDocumentoSistema.CPF, existingPessoa.getTipoDocumentoSistema(), "tipoDocumentoSistema não deveria mudar (nulo no source)");
        assertEquals(123456789, existingPessoa.getNumeroDocumentoSistema(), "numeroDocumentoSistema não deveria mudar (nulo no source)");
        assertEquals(LocalDate.of(2024, 1, 1), existingPessoa.getDataInclusao(), "dataInclusao deve ser ignorada");
        assertTrue(existingPessoa.getDataAtualizacao().isAfter(dataBefore) || existingPessoa.getDataAtualizacao().isEqual(LocalDate.now()),
                "dataAtualizacao deve ser atualizada para hoje");
    }
}


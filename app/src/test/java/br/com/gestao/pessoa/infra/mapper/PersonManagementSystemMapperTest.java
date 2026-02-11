package br.com.gestao.pessoa.infra.mapper;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.entity.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonManagementSystemMapperTest {

    private PersonManagementSystemEntity existingPerson;
    private PersonManagementSystemEntity updateSource;

    @BeforeEach
    public void setUp() {
        // Setup entity already existing in database
        existingPerson = new PersonManagementSystemEntity();
        existingPerson.setPersonSystemCode(1);
        existingPerson.setPersonSystemName("Original Name");
        existingPerson.setDocumentSystemType(DocumentType.CPF);
        existingPerson.setDocumentNumberSystem(123456789);
        existingPerson.setInclusionDate(LocalDate.of(2024, 1, 1));
        existingPerson.setUpdateDate(LocalDate.of(2024, 1, 1));
        existingPerson.setPersonActiveIndicator(true);

        // Setup entity with partial data for update
        updateSource = new PersonManagementSystemEntity();
        updateSource.setPersonSystemCode(999); // should be ignored
        updateSource.setPersonSystemName("Updated Name");
        // other null fields = should be ignored
    }

    @Test
    public void testUpdatePersonFromEntityPartialUpdate() {
        LocalDate dateBeforeUpdate = existingPerson.getUpdateDate();

        // Apply update
        PersonManagementSystemMapper.INSTANCE.updatePersonFromEntity(updateSource, existingPerson);

        // Validations
        assertEquals(1, existingPerson.getPersonSystemCode(), "personSystemCode should be ignored");
        assertEquals("Updated Name", existingPerson.getPersonSystemName(), "name should be updated");
        assertEquals(DocumentType.CPF, existingPerson.getDocumentSystemType(), "documentSystemType should not change (null in source)");
        assertEquals(123456789, existingPerson.getDocumentNumberSystem(), "documentNumberSystem should not change (null in source)");
        assertEquals(LocalDate.of(2024, 1, 1), existingPerson.getInclusionDate(), "inclusionDate should be ignored");
        assertTrue(existingPerson.getUpdateDate().isAfter(dateBeforeUpdate) || existingPerson.getUpdateDate().isEqual(LocalDate.now()),
                "updateDate should be updated to today");
    }
}

package br.com.gestao.pessoa.infra.mapper;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.entity.enums.DocumentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PersonManagementSystemMapper Tests")
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
    @DisplayName("Should update person with partial data - ignoring null fields")
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

    @Test
    @DisplayName("Should update person with all fields populated")
    public void testUpdatePersonFromEntityFullUpdate() {
        updateSource.setDocumentNumberSystem(987654321);
        updateSource.setAdmissionDate(LocalDate.of(2024, 3, 15));
        updateSource.setTerminationDate(LocalDate.of(2024, 6, 30));
        updateSource.setPersonActiveIndicator(false);

        PersonManagementSystemMapper.INSTANCE.updatePersonFromEntity(updateSource, existingPerson);

        assertEquals("Updated Name", existingPerson.getPersonSystemName());
        assertEquals(987654321, existingPerson.getDocumentNumberSystem());
        assertEquals(LocalDate.of(2024, 3, 15), existingPerson.getAdmissionDate());
        assertEquals(LocalDate.of(2024, 6, 30), existingPerson.getTerminationDate());
        assertFalse(existingPerson.getPersonActiveIndicator());
        assertEquals(LocalDate.now(), existingPerson.getUpdateDate());
    }

    @Test
    @DisplayName("Should preserve original values when source fields are null")
    public void testUpdatePersonPreservesNullFields() {
        String originalName = existingPerson.getPersonSystemName();
        DocumentType originalDocType = existingPerson.getDocumentSystemType();

        // updateSource has name set but other fields are null
        updateSource.setPersonSystemName("New Name");

        PersonManagementSystemMapper.INSTANCE.updatePersonFromEntity(updateSource, existingPerson);

        assertEquals("New Name", existingPerson.getPersonSystemName());
        assertEquals(originalDocType, existingPerson.getDocumentSystemType());
        assertEquals(originalName, "Original Name");
    }

    @Test
    @DisplayName("Should mark person as inactive with current date on logical delete")
    public void testDeletePersonLogical() {
        assertTrue(existingPerson.getPersonActiveIndicator(), "Person should be active before delete");
        assertNull(existingPerson.getTerminationDate(), "Termination date should be null before delete");

        PersonManagementSystemMapper.INSTANCE.deletePersonLogical(updateSource, existingPerson);

        assertFalse(existingPerson.getPersonActiveIndicator(), "Person should be inactive after logical delete");
        assertEquals(LocalDate.now(), existingPerson.getTerminationDate(), "Termination date should be set to today");
        assertEquals(LocalDate.now(), existingPerson.getUpdateDate(), "Update date should be set to today");
    }

    @Test
    @DisplayName("Should set correct dates on logical delete")
    public void testDeletePersonLogicalDates() {
        LocalDate beforeDelete = LocalDate.now();

        PersonManagementSystemMapper.INSTANCE.deletePersonLogical(updateSource, existingPerson);

        LocalDate afterDelete = LocalDate.now();

        assertTrue(existingPerson.getTerminationDate().isAfter(beforeDelete.minusDays(1)) &&
                   existingPerson.getTerminationDate().isBefore(afterDelete.plusDays(1)));
        assertTrue(existingPerson.getUpdateDate().isAfter(beforeDelete.minusDays(1)) &&
                   existingPerson.getUpdateDate().isBefore(afterDelete.plusDays(1)));
    }

    @Test
    @DisplayName("Should preserve person code and inclusion date on logical delete")
    public void testDeletePersonLogicalPreservesIdentifiers() {
        Integer originalCode = existingPerson.getPersonSystemCode();
        LocalDate originalInclusionDate = existingPerson.getInclusionDate();

        PersonManagementSystemMapper.INSTANCE.deletePersonLogical(updateSource, existingPerson);

        assertEquals(originalCode, existingPerson.getPersonSystemCode());
        assertEquals(originalInclusionDate, existingPerson.getInclusionDate());
    }
}

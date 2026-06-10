package br.com.gestao.pessoa.infra.adapter;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.entity.enums.DocumentType;
import br.com.gestao.pessoa.exception.Response400Exception;
import br.com.gestao.pessoa.exception.Response404Exception;
import br.com.gestao.pessoa.infra.repository.PersonManagementSystemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("PersonManagementSystemUseCaseImpl Tests")
public class PersonManagementSystemUseCaseImplTest {

    @Mock
    private PersonManagementSystemRepository repository;

    @InjectMocks
    private PersonManagementSystemUseCaseImpl useCase;

    private PersonManagementSystemEntity testPerson;

    @BeforeEach
    public void setUp() {
        testPerson = new PersonManagementSystemEntity();
        testPerson.setPersonSystemCode(1);
        testPerson.setPersonSystemName("João Silva");
        testPerson.setDocumentSystemType(DocumentType.CPF);
        testPerson.setDocumentNumberSystem(123456789);
        testPerson.setAdmissionDate(LocalDate.of(2024, 1, 15));
        testPerson.setInclusionDate(LocalDate.now());
        testPerson.setUpdateDate(LocalDate.now());
        testPerson.setPersonActiveIndicator(true);
    }

    @Test
    @DisplayName("Should get all active persons successfully")
    public void testGetAllPersonsManagementSystemSuccess() {
        List<PersonManagementSystemEntity> persons = new ArrayList<>();
        persons.add(testPerson);

        when(repository.findAllPersons()).thenReturn(persons);

        List<PersonManagementSystemEntity> result = useCase.getAllPersonsManagementSystem();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("João Silva", result.get(0).getPersonSystemName());
        verify(repository, times(1)).findAllPersons();
    }

    @Test
    @DisplayName("Should throw exception when no persons found in getAll")
    public void testGetAllPersonsManagementSystemThrowsException() {
        when(repository.findAllPersons()).thenReturn(new ArrayList<>());

        assertThrows(Response400Exception.class, () -> useCase.getAllPersonsManagementSystem());
        verify(repository, times(1)).findAllPersons();
    }

    @Test
    @DisplayName("Should get person by ID successfully")
    public void testGetPersonByIdManagementSystemSuccess() {
        when(repository.findByIdPerson(1)).thenReturn(Optional.of(testPerson));

        PersonManagementSystemEntity result = useCase.getPersonByIdManagementSystem(1);

        assertNotNull(result);
        assertEquals(1, result.getPersonSystemCode());
        assertEquals("João Silva", result.getPersonSystemName());
        verify(repository, times(1)).findByIdPerson(1);
    }

    @Test
    @DisplayName("Should throw exception when person not found by ID")
    public void testGetPersonByIdManagementSystemThrowsException() {
        when(repository.findByIdPerson(999)).thenReturn(Optional.empty());

        assertThrows(Response400Exception.class, () -> useCase.getPersonByIdManagementSystem(999));
        verify(repository, times(1)).findByIdPerson(999);
    }

    @Test
    @DisplayName("Should create new person successfully")
    public void testCreatePersonManagementSystemSuccess() {
        testPerson.setPersonSystemCode(null); // New person should not have code yet
        PersonManagementSystemEntity savedPerson = new PersonManagementSystemEntity();
        savedPerson.setPersonSystemCode(1);
        savedPerson.setPersonSystemName("João Silva");
        savedPerson.setDocumentSystemType(DocumentType.CPF);
        savedPerson.setDocumentNumberSystem(123456789);
        savedPerson.setAdmissionDate(LocalDate.of(2024, 1, 15));
        savedPerson.setInclusionDate(LocalDate.now());
        savedPerson.setUpdateDate(LocalDate.now());
        savedPerson.setPersonActiveIndicator(true);

        when(repository.save(any(PersonManagementSystemEntity.class))).thenReturn(savedPerson);

        PersonManagementSystemEntity result = useCase.createPersonManagementSystem(testPerson);

        assertNotNull(result);
        assertNotNull(result.getPersonSystemCode());
        assertEquals("João Silva", result.getPersonSystemName());
        verify(repository, times(1)).save(any(PersonManagementSystemEntity.class));
    }

    @Test
    @DisplayName("Should update existing person successfully")
    public void testUpdatePersonManagementSystemSuccess() {
        PersonManagementSystemEntity updateData = new PersonManagementSystemEntity();
        updateData.setPersonSystemCode(1);
        updateData.setPersonSystemName("João Silva Atualizado");

        PersonManagementSystemEntity existingPerson = new PersonManagementSystemEntity();
        existingPerson.setPersonSystemCode(1);
        existingPerson.setPersonSystemName("João Silva");
        existingPerson.setDocumentSystemType(DocumentType.CPF);
        existingPerson.setDocumentNumberSystem(123456789);
        existingPerson.setAdmissionDate(LocalDate.of(2024, 1, 15));
        existingPerson.setInclusionDate(LocalDate.now());
        existingPerson.setUpdateDate(LocalDate.now());
        existingPerson.setPersonActiveIndicator(true);

        PersonManagementSystemEntity updatedPerson = new PersonManagementSystemEntity();
        updatedPerson.setPersonSystemCode(1);
        updatedPerson.setPersonSystemName("João Silva Atualizado");
        updatedPerson.setDocumentSystemType(DocumentType.CPF);
        updatedPerson.setDocumentNumberSystem(123456789);
        updatedPerson.setAdmissionDate(LocalDate.of(2024, 1, 15));
        updatedPerson.setInclusionDate(LocalDate.now());
        updatedPerson.setUpdateDate(LocalDate.now());
        updatedPerson.setPersonActiveIndicator(true);

        when(repository.findByIdPerson(1)).thenReturn(Optional.of(existingPerson));
        when(repository.save(any(PersonManagementSystemEntity.class))).thenReturn(updatedPerson);

        PersonManagementSystemEntity result = useCase.updatePersonManagementSystem(updateData);

        assertNotNull(result);
        assertEquals("João Silva Atualizado", result.getPersonSystemName());
        verify(repository, times(1)).findByIdPerson(1);
        verify(repository, times(1)).save(any(PersonManagementSystemEntity.class));
    }

    @Test
    @DisplayName("Should perform logical delete successfully")
    public void testDeletePersonManagementSystemSuccess() {
        PersonManagementSystemEntity existingPerson = new PersonManagementSystemEntity();
        existingPerson.setPersonSystemCode(1);
        existingPerson.setPersonSystemName("João Silva");
        existingPerson.setDocumentSystemType(DocumentType.CPF);
        existingPerson.setDocumentNumberSystem(123456789);
        existingPerson.setAdmissionDate(LocalDate.of(2024, 1, 15));
        existingPerson.setInclusionDate(LocalDate.now());
        existingPerson.setUpdateDate(LocalDate.now());
        existingPerson.setPersonActiveIndicator(true);

        PersonManagementSystemEntity deletedPerson = new PersonManagementSystemEntity();
        deletedPerson.setPersonSystemCode(1);
        deletedPerson.setPersonSystemName("João Silva");
        deletedPerson.setDocumentSystemType(DocumentType.CPF);
        deletedPerson.setDocumentNumberSystem(123456789);
        deletedPerson.setAdmissionDate(LocalDate.of(2024, 1, 15));
        deletedPerson.setInclusionDate(LocalDate.now());
        deletedPerson.setUpdateDate(LocalDate.now());
        deletedPerson.setTerminationDate(LocalDate.now());
        deletedPerson.setPersonActiveIndicator(false);

        when(repository.findByIdPerson(1)).thenReturn(Optional.of(existingPerson));
        when(repository.save(any(PersonManagementSystemEntity.class))).thenReturn(deletedPerson);

        PersonManagementSystemEntity result = useCase.deletePersonManagementSystem(testPerson);

        assertNotNull(result);
        assertFalse(result.getPersonActiveIndicator());
        assertNotNull(result.getTerminationDate());
        verify(repository, times(1)).findByIdPerson(1);
        verify(repository, times(1)).save(any(PersonManagementSystemEntity.class));
    }

    @Test
    @DisplayName("Should handle multiple persons in getAll")
    public void testGetAllPersonsManagementSystemMultiplePersons() {
        List<PersonManagementSystemEntity> persons = new ArrayList<>();

        PersonManagementSystemEntity person1 = new PersonManagementSystemEntity();
        person1.setPersonSystemCode(1);
        person1.setPersonSystemName("João Silva");
        person1.setDocumentSystemType(DocumentType.CPF);
        person1.setDocumentNumberSystem(123456789);
        person1.setPersonActiveIndicator(true);
        persons.add(person1);

        PersonManagementSystemEntity person2 = new PersonManagementSystemEntity();
        person2.setPersonSystemCode(2);
        person2.setPersonSystemName("Maria Santos");
        person2.setDocumentSystemType(DocumentType.CPF);
        person2.setDocumentNumberSystem(987654321);
        person2.setPersonActiveIndicator(true);
        persons.add(person2);

        when(repository.findAllPersons()).thenReturn(persons);

        List<PersonManagementSystemEntity> result = useCase.getAllPersonsManagementSystem();

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p.getPersonSystemName().equals("João Silva")));
        assertTrue(result.stream().anyMatch(p -> p.getPersonSystemName().equals("Maria Santos")));
        verify(repository, times(1)).findAllPersons();
    }
}

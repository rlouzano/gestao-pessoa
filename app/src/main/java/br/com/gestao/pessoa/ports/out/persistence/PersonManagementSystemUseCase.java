package br.com.gestao.pessoa.ports.out.persistence;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;

import java.util.List;

public interface PersonManagementSystemUseCase {

    List<PersonManagementSystemEntity> getAllPersonsManagementSystem();

    PersonManagementSystemEntity getPersonByIdManagementSystem(final Integer personId);

    PersonManagementSystemEntity createPersonManagementSystem(final PersonManagementSystemEntity personManagementSystemEntity);

    PersonManagementSystemEntity updatePersonManagementSystem(final PersonManagementSystemEntity personManagementSystemEntity);

    PersonManagementSystemEntity deletePersonManagementSystem(final PersonManagementSystemEntity personManagementSystemEntity);
}

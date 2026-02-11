package br.com.gestao.pessoa.infra.repository;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonManagementSystemRepository extends JpaRepository<PersonManagementSystemEntity, Integer> {

    String FIND_ALL = "SELECT personManagementSystemEntity FROM PersonManagementSystemEntity personManagementSystemEntity " +
            "WHERE personManagementSystemEntity.personActiveIndicator is true";

    String FIND_BY_ID_PERSON = "SELECT personManagementSystemEntity FROM PersonManagementSystemEntity personManagementSystemEntity " +
            "WHERE personManagementSystemEntity.personSystemCode = :personId " +
            "AND personManagementSystemEntity.personActiveIndicator is true";


    @Query(value = FIND_ALL)
    List<PersonManagementSystemEntity> findAllPersons();

    @Query(value = FIND_BY_ID_PERSON)
    Optional<PersonManagementSystemEntity> findByIdPerson(final Integer personId);
}

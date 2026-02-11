package br.com.gestao.pessoa.infra.adapter;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.exception.Response404Exception;
import br.com.gestao.pessoa.infra.mapper.PersonManagementSystemMapper;
import br.com.gestao.pessoa.infra.repository.PersonManagementSystemRepository;
import br.com.gestao.pessoa.ports.out.persistence.PersonManagementSystemUseCase;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonManagementSystemUseCaseImpl implements PersonManagementSystemUseCase {

    @Autowired
    private PersonManagementSystemRepository personManagementSystemRepository;

    @Override
    public List<PersonManagementSystemEntity> getAllPersonsManagementSystem() {
        List<PersonManagementSystemEntity> personManagementSystemEntities =
                personManagementSystemRepository.findAllPersons();
        if (CollectionUtils.isNotEmpty(personManagementSystemEntities)) {
            return personManagementSystemEntities;
        }
        throw new Response404Exception("List of people not found.");
    }

    @Override
    public PersonManagementSystemEntity getPersonByIdManagementSystem(final Integer personId) {
        return personManagementSystemRepository.findByIdPerson(personId)
                .orElseThrow(() -> new Response404Exception("People not found."));
    }

    @Override
    public PersonManagementSystemEntity createPersonManagementSystem(final PersonManagementSystemEntity personManagementSystemEntity) {
        return personManagementSystemRepository.save(personManagementSystemEntity);
    }


    @Override
    public PersonManagementSystemEntity updatePersonManagementSystem(
            final PersonManagementSystemEntity personManagementSystemEntity) {
        return personManagementSystemRepository.findByIdPerson(personManagementSystemEntity.getPersonSystemCode())
                .map(personExisting -> {
                    PersonManagementSystemMapper.INSTANCE.updatePersonFromEntity(personManagementSystemEntity, personExisting);
                    return personManagementSystemRepository.save(personExisting);
                })
                .orElseThrow(() -> new Response404Exception("People not found."));
    }

    @Override
    public PersonManagementSystemEntity deletePersonManagementSystem(
            final PersonManagementSystemEntity personManagementSystemEntity) {
        return personManagementSystemRepository.findByIdPerson(personManagementSystemEntity.getPersonSystemCode())
                .map(personExisting -> {
                    PersonManagementSystemMapper.INSTANCE.deletePersonLogical(personManagementSystemEntity, personExisting);
                    return personManagementSystemRepository.save(personExisting);
                })
                .orElseThrow(() -> new Response404Exception("People not found."));
    }

}

package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.ports.in.web.GetPersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PersonManagementSystemUseCase;
import br.com.gestao.pessoa.service.mapper.PersonManagementSystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonManagementSystemUseCaseImpl implements GetPersonManagementSystemUseCasePort {

    @Autowired
    private PersonManagementSystemUseCase personManagementSystemUseCase;

    @Override
    public List<PersonManagementSystemDTO> getPersonManagementSystem() {
        List<PersonManagementSystemEntity> personManagementSystemEntities =
                personManagementSystemUseCase.getAllPersonsManagementSystem();
        return PersonManagementSystemMapper.INSTANCE.mapToDto(personManagementSystemEntities);
    }

    @Override
    public PersonManagementSystemDTO getPersonManagementSystemByIdPerson(final Integer personId) {
        PersonManagementSystemEntity personManagementSystemEntity =
                personManagementSystemUseCase.getPersonByIdManagementSystem(personId);
        return PersonManagementSystemMapper.INSTANCE.mapToDto(personManagementSystemEntity);
    }
}

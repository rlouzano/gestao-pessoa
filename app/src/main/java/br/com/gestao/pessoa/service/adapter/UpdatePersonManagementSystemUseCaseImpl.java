package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.ports.in.web.UpdatePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PersonManagementSystemUseCase;
import br.com.gestao.pessoa.service.mapper.PersonManagementSystemMapper;
import br.com.gestao.pessoa.service.mapper.UpdatePersonManagementSystemMapper;
import br.com.gestao.pessoa.web.requests.PersonManagementSystemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonManagementSystemUseCaseImpl implements UpdatePersonManagementSystemUseCasePort {

    @Autowired
    private PersonManagementSystemUseCase personManagementSystemUseCase;

    @Override
    public PersonManagementSystemDTO updatePersonManagementSystem(final Integer personId, final PersonManagementSystemRequest personManagementSystemRequest) {
        PersonManagementSystemEntity personManagementSystemEntity =
                UpdatePersonManagementSystemMapper.INSTANCE.mapToEntity(personManagementSystemRequest);
        personManagementSystemEntity.setPersonSystemCode(personId);
        PersonManagementSystemEntity updatedPerson =
                personManagementSystemUseCase.updatePersonManagementSystem(personManagementSystemEntity);
        return PersonManagementSystemMapper.INSTANCE.mapToDto(updatedPerson);
    }
}

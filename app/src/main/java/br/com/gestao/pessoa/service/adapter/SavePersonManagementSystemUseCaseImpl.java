package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.ports.in.web.SavePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PersonManagementSystemUseCase;
import br.com.gestao.pessoa.service.mapper.PersonManagementSystemMapper;
import br.com.gestao.pessoa.service.mapper.SavePersonManagementSystemMapper;
import br.com.gestao.pessoa.web.requests.PersonManagementSystemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePersonManagementSystemUseCaseImpl implements SavePersonManagementSystemUseCasePort {

    @Autowired
    private PersonManagementSystemUseCase personManagementSystemUseCase;


    @Override
    public PersonManagementSystemDTO createPersonManagementSystemRequest(final PersonManagementSystemRequest personManagementSystemRequest) {
        PersonManagementSystemEntity personManagementSystemEntity =
                SavePersonManagementSystemMapper.INSTANCE.mapToDto(personManagementSystemRequest);
        PersonManagementSystemEntity createdPerson =
                personManagementSystemUseCase.createPersonManagementSystem(personManagementSystemEntity);
        return PersonManagementSystemMapper.INSTANCE.mapToDto(createdPerson);
    }
}

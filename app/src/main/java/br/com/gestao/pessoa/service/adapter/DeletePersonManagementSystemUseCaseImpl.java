package br.com.gestao.pessoa.service.adapter;

import br.com.gestao.pessoa.entity.PersonManagementSystemEntity;
import br.com.gestao.pessoa.ports.in.web.DeletePersonManagementSystemUseCasePort;
import br.com.gestao.pessoa.ports.out.persistence.PersonManagementSystemUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonManagementSystemUseCaseImpl implements DeletePersonManagementSystemUseCasePort {

    @Autowired
    private PersonManagementSystemUseCase personManagementSystemUseCase;

    @Override
    public void deletePersonManagementSystem(final Integer personId) {
        PersonManagementSystemEntity personManagementSystemEntity = new PersonManagementSystemEntity();
        personManagementSystemEntity.setPersonSystemCode(personId);
        personManagementSystemUseCase.deletePersonManagementSystem(personManagementSystemEntity);
    }
}


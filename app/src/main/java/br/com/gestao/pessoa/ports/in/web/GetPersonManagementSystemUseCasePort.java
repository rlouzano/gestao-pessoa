package br.com.gestao.pessoa.ports.in.web;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;

import java.util.List;

public interface GetPersonManagementSystemUseCasePort {

    List<PersonManagementSystemDTO> getPersonManagementSystem();

    PersonManagementSystemDTO getPersonManagementSystemByIdPerson(final Integer personId);
}

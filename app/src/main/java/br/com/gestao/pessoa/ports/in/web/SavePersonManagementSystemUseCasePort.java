package br.com.gestao.pessoa.ports.in.web;

import br.com.gestao.pessoa.domain.dto.PersonManagementSystemDTO;
import br.com.gestao.pessoa.web.requests.PersonManagementSystemRequest;

public interface SavePersonManagementSystemUseCasePort {

    PersonManagementSystemDTO createPersonManagementSystemRequest(PersonManagementSystemRequest personManagementSystemRequest);
}

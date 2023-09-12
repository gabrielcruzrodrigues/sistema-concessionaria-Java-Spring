package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.repositories.personRepositories.ClientRepository;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client findByClientCpf(String cpf) {
        Optional<Client> client = this.clientRepository.findByClientCpf(cpf);
        return client.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! cpf: " + cpf + ", Tipo: " + Client.class.getName()
        ));
    }

}

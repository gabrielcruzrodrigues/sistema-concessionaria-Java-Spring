package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.repositories.personRepositories.ClientRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client create(Client clientObj) {
        clientObj.setId(null);
        return clientRepository.save(clientObj);
    }

    public Client findByClientCpf(String cpf) {
        Optional<Client> client = Optional.ofNullable(clientRepository.findByClientCpf(cpf));
        log.info(client.get().getCpf());
        return client.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! cpf: " + cpf + ", Tipo: " + Client.class.getName()
        ));
    }

    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id + ", Tipo: " + Client.class.getName()
        ));
    }

    @Transactional
    public void update(Client clientObj) {
        Client newClient = findById(clientObj.getId());

        //data not changed
        newClient.setId(clientObj.getId());
        newClient.setName(clientObj.getName());
//        newClient.setDateOfBirth(clientObj.getDateOfBirth());
        newClient.setCpf(clientObj.getCpf());
        newClient.setEmail(clientObj.getEmail());
        newClient.setNationality(clientObj.getNationality());

        this.clientRepository.save(newClient);
    }

    public void delete(Client client) {
        findById(client.getId());
        try {
            clientRepository.delete(client);
        } catch(Exception ex) {
            throw new DataBidingViolationException("Não a possivel excluir pois há entidades relacionadas");
        }
    }
}

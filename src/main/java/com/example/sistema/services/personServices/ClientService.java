package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.repositories.personRepositories.ClientRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

//    public Client findByClientCpf(String cpf) {
//        Optional<Client> client = Optional.ofNullable(clientRepository.findByClientCpf(cpf));
//        log.info(client.get().getCpf());
//        return client.orElseThrow(() -> new ObjectNotFoundException(
//                "Cliente não encontrado! cpf: " + cpf + ", Tipo: " + Client.class.getName()
//        ));
//    }

    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! Id: " + id));
    }

    @Transactional
    public Client update(Client clientObj, Long id) {
        clientObj.setId(id);
        Client newClient = findById(clientObj.getId());

        //data not changed
        newClient.setId(clientObj.getId());
        newClient.setName(clientObj.getName());
        newClient.setCpf(clientObj.getCpf());
        newClient.setEmail(clientObj.getEmail());
        newClient.setNationality(clientObj.getNationality());

        return clientRepository.save(newClient);
    }

    public void delete(Long id) {
        findById(id);
        try {
            clientRepository.deleteById(id);
        } catch(Exception ex) {
            throw new DataBidingViolationException("Não a possivel excluir pois há entidades relacionadas");
        }
    }


}

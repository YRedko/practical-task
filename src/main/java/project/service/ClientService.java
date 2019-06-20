package project.service;

import project.dao.ClientRepository;
import project.domain.Client;
import project.exceptions.EntityNotFound;

import java.util.List;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(){return null;}

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public void delete(Long id){
        clientRepository.delete(id);
    }

    private Client getClient(long id){
        return clientRepository.findById(id).orElseThrow(EntityNotFound::new);
    }
}

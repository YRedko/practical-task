package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.ClientRepository;
import project.domain.Client;
import project.domain.dto.ClientDto;
import project.domain.mappers.ClientMapper;
import project.exceptions.EntityNotFound;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Transactional
    public Client addClient(Client client){
        return clientRepository.saveAndFlush(client);
    }

    @Transactional
    public Client editClient(Long id, ClientDto clientDto) {
        Client client = getClient(id);
        if(client == null){
            throw new EntityNotFound();
        }
        Client updatedClient = clientMapper.toClient(clientDto, client);
        updatedClient.setId(id);
        return clientRepository.saveAndFlush(updatedClient);
    }

    public Page<Client> getAllClients(Pageable pageable){
        return clientRepository.findAll(pageable);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

    private Client getClient(long id){
        return clientRepository.findById(id).orElseThrow(EntityNotFound::new);
    }
}

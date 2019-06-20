package project.dao;

import project.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    Client save(Client client);

    List<Client> findAll();

    Optional<Client> findById(Long id);

    void delete(Long id);
}

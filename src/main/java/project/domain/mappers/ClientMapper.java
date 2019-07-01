package project.domain.mappers;

import project.domain.Client;
import project.domain.dto.ClientDto;

//@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client toNewClient(ClientDto clientDto);
    ClientDto toNewClientDto(Client client);
    Client toClient(ClientDto clientDto, Client client);
}

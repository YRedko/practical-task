package project.domain.mappers;

import org.springframework.stereotype.Component;
import project.domain.Client;
import project.domain.dto.ClientDto;

@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toNewClient(ClientDto clientDto) {
        if(clientDto == null){
            return null;
        }

        Client client = new Client();

        client.setName(clientDto.getName());
        client.setContactName(clientDto.getContactName());
        client.setContactEmail(clientDto.getContactEmail());
        client.setContactPhone(clientDto.getContactPhone());
        client.setContactDetail(clientDto.getContactDetail());

        return client;
    }

    @Override
    public ClientDto toNewClientDto(Client client) {
        if(client == null){
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setName(client.getName());
        clientDto.setContactName(client.getContactName());
        clientDto.setContactEmail(client.getContactEmail());
        clientDto.setContactPhone(client.getContactPhone());
        clientDto.setContactDetail(client.getContactDetail());

        return clientDto;
    }

    @Override
    public Client toClient(ClientDto clientDto, Client client) {
        if(clientDto == null) {
            return null;
        }
        if(clientDto.getName() != null) {
            client.setName(clientDto.getName());
        }
        if(clientDto.getContactName() != null) {
            client.setContactName(clientDto.getContactName());
        }
        if(clientDto.getContactEmail() != null) {
            client.setContactEmail(clientDto.getContactEmail());
        }
        if(clientDto.getContactPhone() != null){
            client.setContactPhone(clientDto.getContactPhone());
        }
        if(clientDto.getContactDetail() != null){
            client.setContactDetail(clientDto.getContactDetail());
        }
        return client;
    }
}

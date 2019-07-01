package project.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import project.domain.Client;
import project.domain.Employee;
import project.domain.dto.ClientDto;
import project.domain.mappers.ClientMapper;
import project.service.ClientService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final HttpSession httpSession;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, HttpSession httpSession, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.httpSession = httpSession;
        this.clientMapper = clientMapper;
    }

    @PostMapping("/new")
    public Client create(@Valid ClientDto clientDto) {
        return clientService.addClient(clientMapper.toNewClient(clientDto));
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable("id") Long id, @Valid @RequestBody ClientDto clientDto) {
        return clientService.editClient(id, clientDto);
    }

    @GetMapping("/all")
    public Page<Client> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return clientService.getAllClients(pageable);
    }

    @PostMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        clientService.delete(id);
    }

    private Employee getUser(){
        return (Employee) httpSession.getAttribute("user");
    }
}

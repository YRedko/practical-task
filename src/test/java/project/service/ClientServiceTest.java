package project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project.dao.ClientRepository;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;
    @Mock
    private ClientRepository clientRepository;

    @Test
    public void addClient() {
    }

    @Test
    public void getAllClients() {
    }

    @Test
    public void delete() {
        clientService.delete(1L);
        verify(clientRepository).deleteById(1L);
        verifyNoMoreInteractions(clientRepository);
    }
}
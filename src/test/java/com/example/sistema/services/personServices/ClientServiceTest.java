package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.repositories.personRepositories.ClientRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import com.example.sistema.util.FormatData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.text.html.Option;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    public static final Long ID = 1L;
    public static final String NAME = "Gabriel Rodrigues";
    public static final String NUMBER = "33900000000";
    public static final String EMAIL = "gabriel@gmail.com";
    public static final String NATIONALITY = "BR";
    public static final boolean IS_ACTIVE = true;
    public static final double CREDIT_COMPANY = 20.000;
    public static final double MONTHLY_SALARY = 7000.000;
    public static final boolean APPROVED_FINANCING = true;
    public static final String CPF = "50385179006";
    public static final String ADDRESS = "Rua Almeida";
    public static final String CLIENT_NOT_FOUND = "client não encontrado.";
    public static final String RELATED_ENTITIES = "Não a possivel excluir pois há entidades relacionadas";
    private Client client;
    private List<Client> clientList;
    private Optional<Client> optionalClient;

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startClient();
    }

    @Test
    void mustReturnAClientInstanceWithSuccess_whenToCallCreate() {
        when(clientRepository.save(client)).thenReturn(client);
        Client response = clientService.create(client);

        assertNotNull(response);
        assertEquals(Client.class, response.getClass());
        assertEquals(CPF, response.getCpf());
        assertEquals(ADDRESS, response.getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getDateOfBirth().toString());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(NAME, response.getName());
        assertEquals(NATIONALITY, response.getNationality());
        assertEquals(NUMBER, response.getPhoneNumber());
        assertEquals(APPROVED_FINANCING, response.getApprovedFinancing());
        assertEquals(CREDIT_COMPANY, response.getCreditCompany());
        assertEquals(MONTHLY_SALARY, response.getMonthlySalary());
    }

    @Test
    void mustReturnAListOfAllClientsWithSuccess_whenToCallFindAllClients() {
        when(clientService.findAllClients()).thenReturn(clientList);
        List<Client> response = clientService.findAllClients();

        assertNotNull(response);
        assertEquals(Client.class, response.get(0).getClass());
        assertEquals(1, response.size());
        assertEquals(CPF, response.get(0).getCpf());
        assertEquals(ADDRESS, response.get(0).getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.get(0).getDateOfBirth().toString());
        assertEquals(EMAIL, response.get(0).getEmail());
        assertEquals(IS_ACTIVE, response.get(0).getIsActive());
        assertEquals(NAME, response.get(0).getName());
        assertEquals(NATIONALITY, response.get(0).getNationality());
        assertEquals(NUMBER, response.get(0).getPhoneNumber());
        assertEquals(APPROVED_FINANCING, response.get(0).getApprovedFinancing());
        assertEquals(CREDIT_COMPANY, response.get(0).getCreditCompany());
        assertEquals(MONTHLY_SALARY, response.get(0).getMonthlySalary());
    }

    @Test
    void mustReturnAObjectNotFoundException_whenToCallFindById() {
        when(clientRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(CLIENT_NOT_FOUND));

        try {
            Client response = clientService.findById(anyLong());
        } catch (Exception ex) {
            assertNotNull(ex);
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(CLIENT_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    void mustReturnAClientInstance_whenToCallFindById() {
        when(clientRepository.findById(anyLong())).thenReturn(optionalClient);
        Optional<Client> response = clientRepository.findById(ID);

        assertNotNull(response);
        assertEquals(Optional.class, response.getClass());
        assertEquals(Client.class, response.get().getClass());
        assertEquals(CPF, response.get().getCpf());
        assertEquals(ADDRESS, response.get().getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.get().getDateOfBirth().toString());
        assertEquals(EMAIL, response.get().getEmail());
        assertEquals(IS_ACTIVE, response.get().getIsActive());
        assertEquals(NAME, response.get().getName());
        assertEquals(NATIONALITY, response.get().getNationality());
        assertEquals(NUMBER, response.get().getPhoneNumber());
        assertEquals(APPROVED_FINANCING, response.get().getApprovedFinancing());
        assertEquals(CREDIT_COMPANY, response.get().getCreditCompany());
        assertEquals(MONTHLY_SALARY, response.get().getMonthlySalary());
    }

    @Test
    void mustReturnAClientInstanceWithUpdateSuccessWithoutChangingImmutableFields_whenToCallUpdate() {
        when(clientRepository.save(any())).thenReturn(client);
        when(clientRepository.findById(anyLong())).thenReturn(optionalClient);
        Client response = clientService.update(client, ID);

        assertNotNull(response);
        assertEquals(Client.class, response.getClass());
        assertEquals(CPF, response.getCpf());
        assertEquals(ADDRESS, response.getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getDateOfBirth().toString());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(NAME, response.getName());
        assertEquals(NATIONALITY, response.getNationality());
        assertEquals(NUMBER, response.getPhoneNumber());
        assertEquals(APPROVED_FINANCING, response.getApprovedFinancing());
        assertEquals(CREDIT_COMPANY, response.getCreditCompany());
        assertEquals(MONTHLY_SALARY, response.getMonthlySalary());
    }

    @Test
    void mustReturnSuccess_whenToCallDelete() {
        doNothing().when(clientRepository).deleteById(anyLong());
        when(clientRepository.findById(anyLong())).thenReturn(optionalClient);
        clientService.delete(ID);

        verify(clientRepository, times(1)).deleteById(anyLong());
    }

    private void startClient() throws ParseException {
        client = new Client(null, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, CREDIT_COMPANY, MONTHLY_SALARY, APPROVED_FINANCING);

        clientList = List.of(new Client(1L, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, CREDIT_COMPANY, MONTHLY_SALARY, APPROVED_FINANCING));

        optionalClient = Optional.of(new Client(null, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, CREDIT_COMPANY, MONTHLY_SALARY, APPROVED_FINANCING));
    }
}
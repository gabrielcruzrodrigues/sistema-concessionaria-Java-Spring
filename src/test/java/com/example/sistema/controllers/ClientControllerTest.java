package com.example.sistema.controllers;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import com.example.sistema.services.personServices.ClientService;
import com.example.sistema.util.FormatData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ClientControllerTest {
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
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startClient();
    }

//    @Test
//    void mustReturnAResponseEntityWithClientInstanceAndStatusCodeOk_whenToCallCreate() {
//        doNothing().when(clientService).create(client);
//        ResponseEntity<Client> response = clientController.create(client);
//
//        assertNotNull(response);
//        assertEquals(Client.class, response.getClass());
//        assertEquals(CPF, response.getBody().getCpf());
//        assertEquals(ADDRESS, response.getBody().getAddress());
//        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getBody().getDateOfBirth().toString());
//        assertEquals(EMAIL, response.getBody().getEmail());
//        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
//        assertEquals(NAME, response.getBody().getName());
//        assertEquals(NATIONALITY, response.getBody().getNationality());
//        assertEquals(NUMBER, response.getBody().getPhoneNumber());
//        assertEquals(APPROVED_FINANCING, response.getBody().getApprovedFinancing());
//        assertEquals(CREDIT_COMPANY, response.getBody().getCreditCompany());
//        assertEquals(MONTHLY_SALARY, response.getBody().getMonthlySalary());
//    }

    @Test
    void mustReturnAResponseEntityWithListOfTheClientAndStatusCodeOk_whenToCallFindAll() {
        when(clientService.findAllClients()).thenReturn(clientList);
        ResponseEntity<List<Client>> response = clientController.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Client.class, response.getBody().get(0).getClass());
        assertEquals(1, response.getBody().size());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(CPF, response.getBody().get(0).getCpf());
        assertEquals(ADDRESS, response.getBody().get(0).getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getBody().get(0).getDateOfBirth().toString());
        assertEquals(EMAIL, response.getBody().get(0).getEmail());
        assertEquals(IS_ACTIVE, response.getBody().get(0).getIsActive());
        assertEquals(NAME, response.getBody().get(0).getName());
        assertEquals(NATIONALITY, response.getBody().get(0).getNationality());
        assertEquals(NUMBER, response.getBody().get(0).getPhoneNumber());
        assertEquals(APPROVED_FINANCING, response.getBody().get(0).getApprovedFinancing());
        assertEquals(CREDIT_COMPANY, response.getBody().get(0).getCreditCompany());
        assertEquals(MONTHLY_SALARY, response.getBody().get(0).getMonthlySalary());
    }

    @Test
    void mustReturnAResponseEntityWithClientInstanceAndStatusCodeOk_whenToCallFindById() {
        when(clientService.findById(anyLong())).thenReturn(client);
        ResponseEntity<Client> response = clientController.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Client.class, response.getBody().getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(CPF, response.getBody().getCpf());
        assertEquals(ADDRESS, response.getBody().getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getBody().getDateOfBirth().toString());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(NATIONALITY, response.getBody().getNationality());
        assertEquals(NUMBER, response.getBody().getPhoneNumber());
        assertEquals(APPROVED_FINANCING, response.getBody().getApprovedFinancing());
        assertEquals(CREDIT_COMPANY, response.getBody().getCreditCompany());
        assertEquals(MONTHLY_SALARY, response.getBody().getMonthlySalary());
    }

    @Test
    void mustReturnAResponseEntityWithClientInstanceAndStatusCodeOk_whenToCallUpdate() {
        when(clientService.update(any(), any())).thenReturn(client);
        ResponseEntity<Client> response = clientController.update(client, ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Client.class, response.getBody().getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(CPF, response.getBody().getCpf());
        assertEquals(ADDRESS, response.getBody().getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getBody().getDateOfBirth().toString());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(NATIONALITY, response.getBody().getNationality());
        assertEquals(NUMBER, response.getBody().getPhoneNumber());
        assertEquals(APPROVED_FINANCING, response.getBody().getApprovedFinancing());
        assertEquals(CREDIT_COMPANY, response.getBody().getCreditCompany());
        assertEquals(MONTHLY_SALARY, response.getBody().getMonthlySalary());
    }

//    @Test
//    void mustReturnAResponseEntityWithStatusCodeOk_whenToCallDelete() {
//    doNothing().when(clientController).delete(anyLong());
//    ResponseEntity<Object> response = clientController.delete(ID);
//
//        assertNotNull(response);
//        assertNotNull(response.getHeaders());
//        assertNotNull(response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }

    void startClient() throws ParseException {
        client = new Client(null, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, CREDIT_COMPANY, MONTHLY_SALARY, APPROVED_FINANCING);

        clientList = List.of(new Client(1L, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, CREDIT_COMPANY, MONTHLY_SALARY, APPROVED_FINANCING));

        optionalClient = Optional.of(new Client(null, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, CREDIT_COMPANY, MONTHLY_SALARY, APPROVED_FINANCING));
    }
}
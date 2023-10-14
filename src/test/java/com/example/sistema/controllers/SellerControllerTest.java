package com.example.sistema.controllers;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.services.personServices.SellerService;
import com.example.sistema.util.FormatData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class SellerControllerTest {
    public static final Long ID = 1L;
    public static final String EMPLOYEE_NOT_FOUND = "Funcionário não encontrado! cpf: " + ID;
    public static final String NAME = "Gabriel Rodrigues";
    public static final String NUMBER = "33900000000";
    public static final String EMAIL = "gabriel@gmail.com";
    public static final String NATIONALITY = "BR";
    public static final boolean IS_ACTIVE = true;
    public static final String CPF = "50385179006";
    public static final String ADDRESS = "Rua Almeida";
    public static final String RELATED_ENTITIES = "Não a possivel excluir pois há entidades relacionadas";
    public static final String SECTOR = "vendas";
    public static final String AREA = "vendas";
    public static final String WORK_SCHEDULE = "9:00 - 18:00";
    public static final double SALARY = 1236.0;
    public static final boolean PCD = false;
    public static final int QUANTITY_SALES = 50;
    public static final int QUANTITY_SALES_MONTH = 5;
    public static final double VALUE_TOTAL_SALES_MONTH = 200.0;
    public static final String CITY_WORK = "Jequié";
    public static final String SELLER_NOT_FOUND = "vendedor não encontrado.";
    public static final String VIOLATION_ERROR = "Não a possivel excluir pois há entidades relacionadas";

    private Seller seller;
    private Seller seller2;
    private Optional<Seller> sellerOptional;
    private List<Seller> sellerList;

    @InjectMocks
    private SellerController sellerController;

    @Mock
    private SellerService sellerService;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startSeller();
    }

//    @Test
//    void mustReturnAResponseEntityWithSellerInstanceAndStatusCodeOk_whenToCallCreate() {
//    doNothing().when(sellerService).create(seller);
//    ResponseEntity<Seller> response = sellerController.create(seller);
//
//        assertNotNull(response);
//        assertEquals(Seller.class, response.getClass());
//        assertEquals(CPF, response.getBody().getCpf());
//        assertEquals(ADDRESS, response.getBody().getAddress());
//        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getBody().getDateOfBirth().toString());
//        assertEquals(EMAIL, response.getBody().getEmail());
//        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
//        assertEquals(NAME, response.getBody().getName());
//        assertEquals(NATIONALITY, response.getBody().getNationality());
//        assertEquals(NUMBER, response.getBody().getPhoneNumber());
//        assertEquals(SECTOR, response.getBody().getSector());
//        assertEquals(AREA, response.getBody().getArea());
//        assertEquals(WORK_SCHEDULE, response.getBody().getWorkSchedule());
//        assertEquals(SALARY, response.getBody().getSalary());
//        assertEquals(PCD, response.getBody().getPcd());
//        assertEquals(QUANTITY_SALES, response.getBody().getQuantitySales());
//        assertEquals(QUANTITY_SALES_MONTH, response.getBody().getQuantitySalesMonth());
//        assertEquals(VALUE_TOTAL_SALES_MONTH, response.getBody().getValueTotalSalesMonth());
//        assertEquals(CITY_WORK, response.getBody().getCityWork());
//    }

    @Test
    void mustReturnAResponseEntityWithListOfTheSellerAndStatusCodeOk_whenToCallFindAllSellers() {
        when(sellerService.findAllSellers()).thenReturn(sellerList);
        ResponseEntity<List<Seller>> response = sellerController.findAllSellers();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Seller.class, response.getBody().get(0).getClass());
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
        assertEquals(SECTOR, response.getBody().get(0).getSector());
        assertEquals(AREA, response.getBody().get(0).getArea());
        assertEquals(WORK_SCHEDULE, response.getBody().get(0).getWorkSchedule());
        assertEquals(SALARY, response.getBody().get(0).getSalary());
        assertEquals(PCD, response.getBody().get(0).getPcd());
        assertEquals(QUANTITY_SALES, response.getBody().get(0).getQuantitySales());
        assertEquals(QUANTITY_SALES_MONTH, response.getBody().get(0).getQuantitySalesMonth());
        assertEquals(VALUE_TOTAL_SALES_MONTH, response.getBody().get(0).getValueTotalSalesMonth());
        assertEquals(CITY_WORK, response.getBody().get(0).getCityWork());
    }

    @Test
    void mustReturnAResponseEntityWithSellerInstanceAndStatusCodeOk_whenToCallFindById() {
        when(sellerService.findById(anyLong())).thenReturn(seller);
        ResponseEntity<Seller> response = sellerController.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Seller.class, response.getBody().getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(CPF, response.getBody().getCpf());
        assertEquals(ADDRESS, response.getBody().getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getBody().getDateOfBirth().toString());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(NATIONALITY, response.getBody().getNationality());
        assertEquals(NUMBER, response.getBody().getPhoneNumber());
        assertEquals(SECTOR, response.getBody().getSector());
        assertEquals(AREA, response.getBody().getArea());
        assertEquals(WORK_SCHEDULE, response.getBody().getWorkSchedule());
        assertEquals(SALARY, response.getBody().getSalary());
        assertEquals(PCD, response.getBody().getPcd());
        assertEquals(QUANTITY_SALES, response.getBody().getQuantitySales());
        assertEquals(QUANTITY_SALES_MONTH, response.getBody().getQuantitySalesMonth());
        assertEquals(VALUE_TOTAL_SALES_MONTH, response.getBody().getValueTotalSalesMonth());
        assertEquals(CITY_WORK, response.getBody().getCityWork());
    }

    @Test
    void mustReturnAResponseEntityWithSellerInstanceAndStatusCodeOk_whenToCallUpdate() {
        when(sellerService.update(any(), any())).thenReturn(seller);
        ResponseEntity<Seller> response = sellerController.update(seller, ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Seller.class, response.getBody().getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(CPF, response.getBody().getCpf());
        assertEquals(ADDRESS, response.getBody().getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getBody().getDateOfBirth().toString());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(IS_ACTIVE, response.getBody().getIsActive());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(NATIONALITY, response.getBody().getNationality());
        assertEquals(NUMBER, response.getBody().getPhoneNumber());
        assertEquals(SECTOR, response.getBody().getSector());
        assertEquals(AREA, response.getBody().getArea());
        assertEquals(WORK_SCHEDULE, response.getBody().getWorkSchedule());
        assertEquals(SALARY, response.getBody().getSalary());
        assertEquals(PCD, response.getBody().getPcd());
        assertEquals(QUANTITY_SALES, response.getBody().getQuantitySales());
        assertEquals(QUANTITY_SALES_MONTH, response.getBody().getQuantitySalesMonth());
        assertEquals(VALUE_TOTAL_SALES_MONTH, response.getBody().getValueTotalSalesMonth());
        assertEquals(CITY_WORK, response.getBody().getCityWork());
    }

    @Test
    void mustReturnAResponseEntityWithStatusCodeOk_whenToCallDelete() {
    doNothing().when(sellerService).delete(anyLong());
    ResponseEntity<String> response = sellerController.delete(ID);

        assertNotNull(response);
        assertNotNull(response.getHeaders());
        assertNotNull(response.getStatusCode());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    void startSeller() throws ParseException {
        seller = new Seller(ID, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS, NUMBER, EMAIL, NATIONALITY, IS_ACTIVE,
                SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD, QUANTITY_SALES, QUANTITY_SALES_MONTH, VALUE_TOTAL_SALES_MONTH, CITY_WORK);

        seller2 = new Seller(ID, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS, NUMBER, EMAIL, NATIONALITY, IS_ACTIVE,
                SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD, QUANTITY_SALES, QUANTITY_SALES_MONTH, VALUE_TOTAL_SALES_MONTH, CITY_WORK);

        sellerOptional = Optional.of(new Seller(ID, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS, NUMBER, EMAIL, NATIONALITY, IS_ACTIVE,
                SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD, QUANTITY_SALES, QUANTITY_SALES_MONTH, VALUE_TOTAL_SALES_MONTH, CITY_WORK));

        sellerList = List.of(new Seller(ID, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS, NUMBER, EMAIL, NATIONALITY, IS_ACTIVE,
                SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD, QUANTITY_SALES, QUANTITY_SALES_MONTH, VALUE_TOTAL_SALES_MONTH, CITY_WORK));
    }
}
package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Seller;
import com.example.sistema.repositories.personRepositories.SellerRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import com.example.sistema.util.FormatData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.w3c.dom.stylesheets.LinkStyle;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SellerServiceTest {
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
    private SellerService sellerService;

    @Mock
    private SellerRepository sellerRepository;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startSeller();
    }

    @Test
    void mustReturnASellerInstanceWithSuccess_whenToCallCreate() {
        when(sellerRepository.save(seller)).thenReturn(seller);
        Seller response = sellerService.create(seller);

        assertNotNull(response);
        assertEquals(Seller.class, response.getClass());
        assertEquals(CPF, response.getCpf());
        assertEquals(ADDRESS, response.getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getDateOfBirth().toString());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(NAME, response.getName());
        assertEquals(NATIONALITY, response.getNationality());
        assertEquals(NUMBER, response.getPhoneNumber());
        assertEquals(SECTOR, response.getSector());
        assertEquals(AREA, response.getArea());
        assertEquals(WORK_SCHEDULE, response.getWorkSchedule());
        assertEquals(SALARY, response.getSalary());
        assertEquals(PCD, response.getPcd());
        assertEquals(QUANTITY_SALES, response.getQuantitySales());
        assertEquals(QUANTITY_SALES_MONTH, response.getQuantitySalesMonth());
        assertEquals(VALUE_TOTAL_SALES_MONTH, response.getValueTotalSalesMonth());
        assertEquals(CITY_WORK, response.getCityWork());
    }

    @Test
    void mustReturnASellerObject_whenToCallFindById() {
        when(sellerRepository.findById(anyLong())).thenReturn(sellerOptional);
        Seller response = sellerService.findById(ID);

        assertNotNull(response);
        assertEquals(Seller.class, response.getClass());
        assertEquals(CPF, response.getCpf());
        assertEquals(ADDRESS, response.getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getDateOfBirth().toString());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(NAME, response.getName());
        assertEquals(NATIONALITY, response.getNationality());
        assertEquals(NUMBER, response.getPhoneNumber());
        assertEquals(SECTOR, response.getSector());
        assertEquals(AREA, response.getArea());
        assertEquals(WORK_SCHEDULE, response.getWorkSchedule());
        assertEquals(SALARY, response.getSalary());
        assertEquals(PCD, response.getPcd());
        assertEquals(QUANTITY_SALES, response.getQuantitySales());
        assertEquals(QUANTITY_SALES_MONTH, response.getQuantitySalesMonth());
        assertEquals(VALUE_TOTAL_SALES_MONTH, response.getValueTotalSalesMonth());
        assertEquals(CITY_WORK, response.getCityWork());
    }

    @Test
    void mustReturnAObjectNotFoundException_whenToCallFindById() {
        when(sellerRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(SELLER_NOT_FOUND));
        try {
            sellerService.findById(ID);
        } catch (Exception ex) {
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            assertEquals(SELLER_NOT_FOUND, ex.getMessage());
            assertEquals(ObjectNotFoundException.class, ex.getClass());
        }
    }

    @Test
    void mustReturnAListOfTheSellerWithSuccess_whenToCallFindAllSellers() {
        when(sellerRepository.findAll()).thenReturn(sellerList);
        List<Seller> response = sellerService.findAllSellers();

        assertNotNull(response);
        assertEquals(Seller.class, response.get(0).getClass());
        assertEquals(1, response.size());
        assertEquals(CPF, response.get(0).getCpf());
        assertEquals(ADDRESS, response.get(0).getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.get(0).getDateOfBirth().toString());
        assertEquals(EMAIL, response.get(0).getEmail());
        assertEquals(IS_ACTIVE, response.get(0).getIsActive());
        assertEquals(NAME, response.get(0).getName());
        assertEquals(NATIONALITY, response.get(0).getNationality());
        assertEquals(NUMBER, response.get(0).getPhoneNumber());
        assertEquals(SECTOR, response.get(0).getSector());
        assertEquals(AREA, response.get(0).getArea());
        assertEquals(WORK_SCHEDULE, response.get(0).getWorkSchedule());
        assertEquals(SALARY, response.get(0).getSalary());
        assertEquals(PCD, response.get(0).getPcd());
        assertEquals(QUANTITY_SALES, response.get(0).getQuantitySales());
        assertEquals(QUANTITY_SALES_MONTH, response.get(0).getQuantitySalesMonth());
        assertEquals(VALUE_TOTAL_SALES_MONTH, response.get(0).getValueTotalSalesMonth());
        assertEquals(CITY_WORK, response.get(0).getCityWork());
    }

    @Test
    void mustReturnASellerInstanceWithSuccess_whenToCallUpdate() {
        when(sellerRepository.findById(anyLong())).thenReturn(sellerOptional);
        when(sellerRepository.save(seller)).thenReturn(seller);
        Seller response = sellerService.update(seller2, ID);

        assertNotNull(response);
        assertEquals(Seller.class, response.getClass());
        assertEquals(CPF, response.getCpf());
        assertEquals(ADDRESS, response.getAddress());
        assertEquals("Sun May 12 00:00:00 BRT 2002", response.getDateOfBirth().toString());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(IS_ACTIVE, response.getIsActive());
        assertEquals(NAME, response.getName());
        assertEquals(NATIONALITY, response.getNationality());
        assertEquals(NUMBER, response.getPhoneNumber());
        assertEquals(SECTOR, response.getSector());
        assertEquals(AREA, response.getArea());
        assertEquals(WORK_SCHEDULE, response.getWorkSchedule());
        assertEquals(SALARY, response.getSalary());
        assertEquals(PCD, response.getPcd());
        assertEquals(QUANTITY_SALES, response.getQuantitySales());
        assertEquals(QUANTITY_SALES_MONTH, response.getQuantitySalesMonth());
        assertEquals(VALUE_TOTAL_SALES_MONTH, response.getValueTotalSalesMonth());
        assertEquals(CITY_WORK, response.getCityWork());
    }

    @Test
    void mustReturnAObjectNotFoundException_whenToCallUpdate() {
        when(sellerRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(SELLER_NOT_FOUND));
        try {
            sellerService.update(seller, ID);
        } catch (Exception ex) {
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(SELLER_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    void mustReturnSuccess_whenToCallDelete() {
        doNothing().when(sellerRepository).deleteById(anyLong());
        when(sellerRepository.findById(anyLong())).thenReturn(sellerOptional);
        sellerService.delete(ID);

        verify(sellerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void mustReturnADataBidingViolationException_whenToCallDelete() {
        when(sellerRepository.findById(anyLong())).thenReturn(sellerOptional);
        when(sellerRepository.findById(anyLong())).thenThrow(new DataBidingViolationException(VIOLATION_ERROR));

        try {
            sellerService.delete(ID);
        } catch (Exception ex) {
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            assertEquals(DataBidingViolationException.class, ex.getClass());
            assertEquals(VIOLATION_ERROR, ex.getMessage());
        }
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
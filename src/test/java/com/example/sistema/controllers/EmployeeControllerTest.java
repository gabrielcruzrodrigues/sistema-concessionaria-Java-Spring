package com.example.sistema.controllers;

import com.example.sistema.models.personModels.Employee;
import com.example.sistema.models.personModels.Seller;
import com.example.sistema.services.personServices.EmployeeService;
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

class EmployeeControllerTest {
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
    public static final String SECTOR = "limpeza";
    public static final String AREA = "limpeza";
    public static final String WORK_SCHEDULE = "9:00 - 18:00";
    public static final double SALARY = 1236.0;
    public static final boolean PCD = false;

    private Employee employee;
    private Employee employee2;
    private Optional<Employee> optionalEmployee;
    private List<Employee> employeeList;

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startEmployee();
    }

//    @Test
//    void mustReturnAResponseEntityWithEmployeeInstanceAndStatusCodeOk_whenToCallCreate() {
//    doNothing().when(employeeService).create(employee);
//    ResponseEntity<Employee> response = employeeController.create(employee);
//
//        assertNotNull(response);
//        assertEquals(Employee.class, response.getClass());
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
//    }

    @Test
    void mustReturnAResponseEntityWithListOfTheEmployeeAndStatusCodeOk_whenToCallFindAllEmployees() {
        when(employeeService.getAllEmployee()).thenReturn(employeeList);
        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Employee.class, response.getBody().get(0).getClass());
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
    }

    @Test
    void mustReturnAResponseEntityWithEmployeeInstanceAndStatusCodeOk_whenToCallFindById() {
        when(employeeService.findById(anyLong())).thenReturn(employee);
        ResponseEntity<Employee> response = employeeController.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Employee.class, response.getBody().getClass());
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
    }

    @Test
    void mustReturnAResponseEntityWithEmployeeInstanceAndStatusCodeOk_whenToCallUpdate() {
        when(employeeService.update(any(), any())).thenReturn(employee);
        ResponseEntity<Employee> response = employeeController.update(employee, ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getHeaders());
        assertEquals(Employee.class, response.getBody().getClass());
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
    }

//    @Test
//    void mustReturnAResponseEntityWithStatusCodeOk_whenToCallDelete() {
//    doNothing().when(employeeController).delete(anyLong());
//    ResponseEntity<String> response = employeeController.delete(ID);
//
//        assertNotNull(response);
//        assertNotNull(response.getHeaders());
//        assertNotNull(response.getStatusCode());
//        assertNotNull(response.getBody());
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }

    void startEmployee() throws ParseException {
        employee = new Employee(null, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD);

        employee2 = new Employee(null, "David", FormatData.formatDate("15/07/2000"), "14605797041", ADDRESS,
                NUMBER, "david@gmail.com", "US", IS_ACTIVE, SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD);

        optionalEmployee = Optional.of(new Employee(null, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD));

        employeeList = List.of(new Employee(null, NAME, FormatData.formatDate("12/05/2002"), CPF, ADDRESS,
                NUMBER, EMAIL, NATIONALITY, IS_ACTIVE, SECTOR, AREA, WORK_SCHEDULE, SALARY, PCD));
    }
}
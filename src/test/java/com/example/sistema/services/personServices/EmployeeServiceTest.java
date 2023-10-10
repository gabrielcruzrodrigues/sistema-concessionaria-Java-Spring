package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Employee;
import com.example.sistema.repositories.personRepositories.EmployeeRepository;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import com.example.sistema.util.FormatData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class EmployeeServiceTest {
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
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startEmployee();
    }

    @Test
    void mustReturnAEmployeeInstanceWithSuccess_whenToCallCreate() {
        when(employeeRepository.save(employee)).thenReturn(employee);
        Employee response = employeeService.create(employee);

        assertNotNull(response);
        assertEquals(Employee.class, response.getClass());
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
    }

    @Test
    void mustReturnAEmployeeInstanceWithSuccess_whenToCallFindById() {
        when(employeeRepository.findById(anyLong())).thenReturn(optionalEmployee);
        Employee response = employeeService.findById(ID);

        assertNotNull(response);
        assertEquals(Employee.class, response.getClass());
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
    }

    @Test
    void mustReturnAObjectNotFoundException_whenToCallFindById() {
        when(employeeRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(EMPLOYEE_NOT_FOUND));

        try {
            employeeService.findById(ID);
        } catch (Exception ex) {
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            assertEquals(EMPLOYEE_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    void mustReturnAListOfTheEmployee_whenToCallGetAllEmployee() {
        when(employeeRepository.findAll()).thenReturn(employeeList);
        List<Employee> response = employeeService.getAllEmployee();

        assertNotNull(response);
        assertNotNull(response.get(0));
        assertEquals(Employee.class, response.get(0).getClass());
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
    }

    @Test
    void mustReturnAEmployeeInstanceWithSuccess_whenToCallUpdate() {
        when(employeeRepository.save(employee2)).thenReturn(employee);
        when(employeeRepository.findById(anyLong())).thenReturn(optionalEmployee);
        Employee response = employeeService.update(employee2, ID);

        assertNotNull(response);
        assertEquals(Employee.class, response.getClass());

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
    }

    @Test
    void mustReturnAObjectNotFoundException_whenToCallUpdate() {
        when(employeeRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(EMPLOYEE_NOT_FOUND));
        try {
            employeeService.update(employee, ID);
        } catch (Exception ex) {
            assertNotNull(ex);
            assertNotNull(ex.getMessage());
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(EMPLOYEE_NOT_FOUND, ex.getMessage());
        }
    }

    @Test
    void mustReturnSuccess_whenToCallDelete() {
        doNothing().when(employeeRepository).deleteById(anyLong());
        when(employeeRepository.findById(anyLong())).thenReturn(optionalEmployee);
        employeeService.delete(ID);

        verify(employeeRepository, times(1)).deleteById(anyLong());
    }

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
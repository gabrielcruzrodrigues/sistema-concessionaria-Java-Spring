package com.example.sistema.services.personServices;

import com.example.sistema.models.personModels.Client;
import com.example.sistema.models.personModels.Employee;
import com.example.sistema.repositories.personRepositories.EmployeeRepository;
import com.example.sistema.services.exceptions.DataBidingViolationException;
import com.example.sistema.services.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee create(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElseThrow(() -> new ObjectNotFoundException(
            "Funcionário não encontrado! cpf: " + id + ", Tipo: " + Employee.class.getName()
        ));
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee update(Employee employeeObj, Long id) {
        employeeObj.setId(id);
        Employee employee = findById(employeeObj.getId());

        employeeObj.setId(employee.getId());
        employeeObj.setName(employee.getName());
//        employeeObj.setHiringDate(employee.getHiringDate());
        employeeObj.setCpf(employee.getCpf());
        employeeObj.setEmail(employee.getEmail());
        employeeObj.setNationality(employee.getNationality());
        return employeeRepository.save(employeeObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            employeeRepository.deleteById(id);
        } catch(Exception ex) {
            throw new DataBidingViolationException("Não a possivel excluir pois há entidades relacionadas");
        }
    }
}

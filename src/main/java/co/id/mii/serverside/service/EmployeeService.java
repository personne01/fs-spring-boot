/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.service;

import co.id.mii.serverside.model.Employee;
import co.id.mii.serverside.model.Role;
import co.id.mii.serverside.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author MSI-JO
 */
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private RoleService roleService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RoleService roleService) {
        this.employeeRepository = employeeRepository;
        this.roleService = roleService;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee not Found"));
    }

    public Employee create(Employee employee) {
        if (employee.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exist");
        }
        findByName(employee.getName());
        employee.getUser().setEmployee(employee);

        List<Role> role = new ArrayList();
        role.add(roleService.getById(1L));
        employee.getUser().setRoles(role);
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        Employee oldEmployee = getById(id);
        if (!oldEmployee.getName().equals(employee.getName())) {
            findByName(employee.getName());
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }

    public void findByName(String name) {
        if (employeeRepository.findByName(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Employee already exists");
        }
    }

}

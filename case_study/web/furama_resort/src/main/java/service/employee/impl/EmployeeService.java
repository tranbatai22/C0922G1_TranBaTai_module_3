package service.employee.impl;

import model.employee.Employee;
import repository.employee.IEmployeeRepository;
import repository.employee.impl.EmployeeRepository;
import service.employee.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {

    IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> displayEmployee() {
        return employeeRepository.displayEmployee();
    }
}

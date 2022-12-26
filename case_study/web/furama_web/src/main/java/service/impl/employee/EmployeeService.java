package service.impl.employee;

import model.employee.Employee;
import repository.IEmployeeRepository;
import repository.impl.employee.EmployeeRepo;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepo();
    @Override
    public List<Employee> displayListEmployee() {
        return employeeRepository.displayListEmployee();
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return employeeRepository.editEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> findEmployee(String employeeName, int position_id, String userName) {
        return employeeRepository.findEmployee(employeeName,position_id,userName);
    }
}
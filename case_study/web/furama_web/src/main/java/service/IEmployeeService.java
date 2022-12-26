package service;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> displayListEmployee();

    boolean insertEmployee(Employee employee);

    Employee findEmployeeById(int id);

    boolean editEmployee(Employee employee);

    boolean deleteEmployee(int id);

    List<Employee> findEmployee(String employeeName,int position_id, String userName);
}
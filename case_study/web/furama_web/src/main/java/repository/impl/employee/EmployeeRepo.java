package repository.impl.employee;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.*;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private final String SELECT_ALL_EMPLOYEE = "select e.*, p.name as position_name, ed.name as education_degree_name, d.name as division_name, u.password from employee e join position p on e.position_id = p.id join education_degree ed on e.education_degree_id = ed.id join division d on e.division_id = d.id join user u on e.user_name = u.user_name;";
    private final String SELECT_EMPLOYEE = "select c.*,ct.name as customer_type_name from customer c join customer_type ct on c.customer_type_id = ct.id where c.id=?";
    private final String FIND_EMPLOYEE_BY = "select c.*,ct.name as customer_type_name from customer c join customer_type ct on c.customer_type_id = ct.id where c.name like ? and c.phone_number like ? and c.address like ?";
    private final String INSERT_EMPLOYEE = "insert into customer (customer_type_id,name,date_of_birth,gender,id_card,phone_number,email,address) values (?,?,?,?,?,?,?,?)";
    private final String EDIT_EMPLOYEE = "update customer set customer_type_id = ?,name=?,date_of_birth=?,gender=?,id_card=?,phone_number=?,email=?,address=? where id = ?;";
    private final String DELETE_EMPLOYEE = "delete from customer where id = ?;";
    private final String SQL_SAFE_UPDATES = "set sql_safe_updates = 0;";
    private final String FOREIGN_KEY_CHECKS = "set foreign_key_checks = 0;";

    @Override
    public List<Employee> displayListEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dateOfBirth = rs.getString("date_of_birth");
                String idCard = rs.getString("id_card");
                double salary = rs.getDouble("salary");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int positionId = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                int educationDegreeId = rs.getInt("education_degree_id");
                String educationDegreeName = rs.getString("education_degree_name");
                int divisionId = rs.getInt("division_id");
                String divisionName = rs.getString("division_name");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                Position position = new Position(positionId,positionName);
                EducationDegree educationDegree = new EducationDegree(educationDegreeId,educationDegreeName);
                Division division = new Division(divisionId,divisionName);
                User user = new User(userName,password);
                employeeList.add(new Employee(id,name,dateOfBirth,idCard,salary,phoneNumber,email,address,position,educationDegree,division,user));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return false;
    }

    @Override
    public Employee findEmployeeById(int id) {
        return null;
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }

    @Override
    public List<Employee> findEmployee(String employeeName, int position_id, String userName) {
        return null;
    }
}
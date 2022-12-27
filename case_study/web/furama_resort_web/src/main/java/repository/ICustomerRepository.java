package repository;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> displayListCustomer();

    boolean insertCustomer(Customer customer);

    Customer findCustomerById(int id);

    boolean editCustomer(Customer customer);

    boolean deleteCustomer(int id);

    List<Customer> findCustomerByName(String customerName,String customerPhoneNumber, String customerAddress);
}
